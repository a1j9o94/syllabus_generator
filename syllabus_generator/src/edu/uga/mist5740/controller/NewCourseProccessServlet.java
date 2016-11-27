package edu.uga.mist5740.controller; //

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uga.mist5740.model.*;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class NewCourseProccessServlet
 */
@WebServlet({ "/NewCourseProccessServlet", "/processCourse" })
public class NewCourseProccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewCourseProccessServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Course newCourse = new Course();
        Instructor newInstructor = new Instructor();
        Calendar newCal = new Calendar();

        HttpSession sess = request.getSession();

        // set course info: instructor, cal, add. notes
        // sets name
        newCourse.setCourseName(request.getParameter("courseName"));
        // sets desc
        newCourse.setCourseDescription(request.getParameter("courseDescription"));
        newCourse.setAdditionalNotes(request.getParameter("courseNotes"));
        sess.setAttribute("course", newCourse);

        // set instructor info:
        // sets first name
        newInstructor.setFirstName(request.getParameter("instructorFirstName"));
        // sets last name
        newInstructor.setLastName(request.getParameter("instructorLastName"));
        // setsphone
        newInstructor.setOfficePhone(request.getParameter("instructorPhoneNumber"));
        // sets add.info
        newInstructor.setAddInfo(request.getParameter("instructorNotes"));
        sess.setAttribute("instructor", newInstructor);

        // if user adds more than one book
        String bookRequired = "bookRequired-";
        String bookName = "bookName-";
        int bookNumber = 1;
        while (request.getParameter(bookRequired + bookNumber) != null) {
            Book newBook = new Book();
            newBook.setBookName(request.getParameter(bookName + bookNumber));
            // gets required of new book
            String checkbox = request.getParameter(bookRequired + bookNumber);
            if (checkbox.equals("on")) {
                newBook.setRequired(true);
            } else {
                newBook.setRequired(false);
            }

            newCourse.addBook(newBook);

            bookNumber++; // increment to check for more
        }

        // grade info
        String gradeWeight = "gradeWeight-";
        String courseName = "courseAspect-";
        int courseNumber = 1;
        // if more than one course aspect
        while (request.getParameter(gradeWeight + courseNumber) != null) {
            Grade g = new Grade();
            g.setGradeName(request.getParameter(courseName + courseNumber));
            g.setGradeWeight(Double.parseDouble(request.getParameter(gradeWeight + courseNumber)));

            newCourse.addGade(g);
            courseNumber++; // check for more
        }

        // calendar/schedule info
        String topicName = "topic-";
        String dateName = "date-";
        String assignmentName = "assignment-";
        int number = 1;
        while (request.getParameter(topicName + number) != null) {
            Date newDate = new Date();
            // month/day/yr format
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = request.getParameter(dateName + number);
            java.util.Date parsedDate = null;
            try {
                parsedDate = df.parse(date);
            } catch (java.text.ParseException e1) {
                forwardError(
                        "There was a problem parsing the date for one of the assignments. Please use the MM/dd/yyyy format ",
                        request, response);
                return;
            }

            // converts to sql date format
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            // sets date info: (for course schedule)
            newDate.setDate(sqlDate);

            // set topic
            newDate.setTopic(request.getParameter(topicName + number));
            // sets assignment
            newDate.setAssignment(request.getParameter(assignmentName + number));

            newCal.addDateToSchedule(newDate);

            number++;
        }
        // special events
        String eventName = "eventName-";
        String eventDate = "eventDate-";
        String eventLocation = "eventLocation-";
        int i = 1;
        while (request.getParameter(eventDate + i) != null) {
            SpecialEvent newEvent = new SpecialEvent();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            String seDate = request.getParameter(eventDate + i);
            java.util.Date parsedDate = null;
            try {
                parsedDate = df.parse(seDate);
            } catch (java.text.ParseException e1) {
                forwardError(
                        "There was a problem parsing the date for one of the assignments. Please use the MM/dd/yyyy format ",
                        request, response);
                return;
            }

            // converts to sql date format
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());

            // sets date info: (for course schedule)
            newEvent.setDatetime(sqlDate);

            // sets name
            newEvent.setName(request.getParameter(eventName + i));

            // sets location
            newEvent.setLocation(request.getParameter(eventLocation + i));

            // add special event to calendar object
            newCal.addSpecialEvent(newEvent);

            i++;
        }

        sess.setAttribute("calendar", newCal); // add calendar to session object

        newCourse.setCalendar(newCal);

        newInstructor.addCourse(newCourse);

        try {
            InstructorModificationManager.addInstructor(newInstructor);
        } catch (Exception e) {
           e.printStackTrace();
            forwardError(
                    "There was a problem adding your course to the database, please try again. ",
                    request, response);
            return;
        }

        request.setAttribute("redirected", null);

        String url = "/result";

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    private void forwardError(String msg, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

        request.setAttribute("errorMsg", msg);
        request.setAttribute("redirected", true);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}

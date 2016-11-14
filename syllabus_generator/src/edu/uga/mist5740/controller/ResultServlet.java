package edu.uga.mist5740.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uga.mist5740.model.Course;
import edu.uga.mist5740.model.Date;
import edu.uga.mist5740.model.Grade;
import edu.uga.mist5740.model.Instructor;
import edu.uga.mist5740.model.InstructorRetrievalManager;
import edu.uga.mist5740.model.SpecialEvent;
import edu.uga.mist5740.model.Book;
import edu.uga.mist5740.model.Calendar;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet({ "/ResultServlet", "/result" })
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ResultServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ArrayList<Instructor> instructors = InstructorRetrievalManager.getInstructors();
			int ID = 1;

			for (Instructor i : instructors) {
				if (i.getInstructorID() == ID) {
					request.setAttribute("Instructor", i);
					ArrayList<Course> courses = i.getCourses();
					Course course = courses.get(courses.size() - 1);
					request.setAttribute("course", course);
					Calendar cal = course.getCalendar();
					ArrayList<Date> schedule = cal.getSchedule();
					request.setAttribute("schedule", schedule);
					ArrayList<SpecialEvent> events = cal.getSpecialEvents();
					request.setAttribute("events", events);
					ArrayList<Grade> weight = course.getWeightings();
					request.setAttribute("weight", weight);
					ArrayList<Book> books = course.getBooks();
					request.setAttribute("books", books);

					break;
				}

			}
			String url = "/results.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		} catch (Exception e) {
		}

	}
}

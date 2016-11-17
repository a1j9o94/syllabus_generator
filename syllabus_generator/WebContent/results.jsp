<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Syllabus Generator</title>
</head>
<body>
<h1>Syllabus Generator</h1>
<h2>${course.courseName}</h2>
<p> http://www.elc.uga.edu
Course Syllabus
University of Georgia - Terry College of Business - MIS Department
The course syllabus is a general plan for the course; deviations announced to the class by the instructor may be necessary.
</p>
<p>
CONTACT INFORMATION AND OFFICE HOURS:
${instructor.firstName} ${instructor.lastName}
Office Phone: ${instructor.officePhone}
</p>
<c:if test = "${instructor.addInfo != null}"> 
<p> Additional Information: ${instructor.addInfo}
</c:if>

Course Description:
${course.courseDescription}

Materials:
${course.books}

Grading Scale:
${course.getWeightings}

Tentative Schedule:
${course.getCalendar}

Academic Honesty: 
As a University of Georgiastudent, you have agreed to abide by the University’s academic honesty 
policy, “A Culture of Honesty,” and the Student Honor Code. All academic work must meet the standards described in a 
“Culture of Honesty” found at http://www.uga.edu/honesty/. Lack of knowledge of the academic honesty policy is not a 
reasonable explanation for a violation. Questions related to course assignments and the academic honesty policy should 
be directed to the instructor.“The academic honesty policy of the University is supplemented (not replaced) by an Honor 
Code which was adopted by the Student Government Association and approved by the University Council May 1, 1997, and 
provides: "I will be academically honest in all of my academic work and will not tolerate academic dishonesty of others.
"All students agree to abide by this code by signing the UGA Admissions Application.” 
Source: http://www.uga.edu/honesty/ahpd/student_honor_code.html. 

Additional Notes:
${course.additionalNotes}

</body>
</html>
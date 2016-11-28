<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Syllabye</title>

<!-- Our Styling -->
<link href="css/resultstyle.css" rel="stylesheet">
</head>
<body>
	<div id="Header">
	<h1>Syllabye Syllabus Generator 1.0</h1>
	</div>
	<h2>${course.courseName}</h2>
	<h4>University of Georgia - Terry College of Business - MIS Department</h4>
	<div id="liability">
		<p>
			<a href="http://www.elc.uga.edu"> Course Syllabus University of
			Georgia</a> - Terry College of Business - MIS Department The course
			syllabus is a general plan for the course; deviations announced to the
			class by the instructor may be necessary.
		</p>
	</div>
	
	<h3>CONTACT INFORMATION:</h3>
	<div id="contact">
		<p>Instructor Name: ${instructor.firstName} ${instructor.lastName}</p>
		<p>Office Phone: ${instructor.officePhone}</p>

		<c:if test="${instructor.addInfo != null}">
			<p>Additional Information: ${instructor.addInfo}</p>
		</c:if>
	</div>

	<h3>Course Description:</h3>
	<div id="description">
		<p>${course.courseDescription}</p>
	</div>

	<h3>Materials</h3>
	<table id="bookTable">

		<tr>
			<th>Book Name</th>
			<th>Required</th>
		</tr>

		<c:forEach var="book" items="${course.books}">
			<tr>
				<td>${book.bookName}</td>
				<td>${book.required}</td>
			</tr>
		</c:forEach>

	</table>


	<h3>Grading Scale</h3>
	<table id="gradeDistTable">
		<tbody>
			<c:forEach var="weight" items="${course.weightings}">
				<tr>
					<td>${weight.gradeName}</td>
					<td>${weight.gradeWeight}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>Tentative Schedule:</h3>
	<table id="dateTable">
		<caption>In Class</caption>
		<tbody>
			<tr>
				<th>Date</th>
				<th>Topic</th>
				<th>Preparation</th>
			</tr>
			<c:forEach var="period" items="${course.calendar.schedule}">
				<tr>
					<td><fmt:formatDate pattern="MM/dd" value="${period.date}" /></td>
					<td>${period.topic}</td>
					<td>${period.assignment}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table id="eventsTable">
		<caption>Outside of Class Events</caption>
		<tr>
			<th>Date</th>
			<th>Name</th>
			<th>Location</th>
		</tr>
		<c:forEach var="event" items="${course.calendar.specialEvents}">
			<tr>
				<td><fmt:formatDate pattern="MM/dd" value="${event.datetime}" /></td>
				<td>${event.name}</td>
				<td>${event.location}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Additional Notes:</h3>
		<p> ${course.additionalNotes}</p>

<div id="honesty">
	<p>Academic Honesty: As a University of Georgia student, you have
		agreed to abide by the University’s academic honesty policy, “A
		Culture of Honesty,” and the Student Honor Code. All academic work
		must meet the standards described in a “Culture of Honesty” found at
		http://www.uga.edu/honesty/. Lack of knowledge of the academic honesty
		policy is not a reasonable explanation for a violation. Questions
		related to course assignments and the academic honesty policy should
		be directed to the instructor.“The academic honesty policy of the
		University is supplemented (not replaced) by an Honor Code which was
		adopted by the Student Government Association and approved by the
		University Council May 1, 1997, and provides: "I will be academically
		honest in all of my academic work and will not tolerate academic
		dishonesty of others. "All students agree to abide by this code by
		signing the UGA Admissions Application.” Source:
		http://www.uga.edu/honesty/ahpd/student_honor_code.html.</p>
	</div>

	<a href="index.jsp"><button>Restart</button></a>

</body>
</html>
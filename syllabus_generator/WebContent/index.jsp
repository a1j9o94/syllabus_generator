
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Syllabye</title>

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Our Styling -->
<link href="css/main.css" rel="stylesheet">

<!-- Jquery UI styling -->
<link rel="stylesheet" href="js/jquery-ui-1.12.0-rc.1/jquery-ui.min.css">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<c:if test="${redirected != null && redirected == true}">
		<p class="error">${errorMsg}</p>
	</c:if>
	<h1>Syllabye Syllabus Generator 1.0</h1>
	<form name="newCourseInput" action="processCourse" method="post">
		<p>
			<label for="courseName">CRN - Course Name:</label>
			<input type="text" name="courseName">
		</p>
		<p>
			<label for="courseDescription">Course Description:</label>
			<input type="text" name="courseDescription">
		</p>
		<p>
			<label for="instructorFirstName">Instructor First Name:</label>
			<input type="text" name="instructorFirstName">
		</p>
		<p>
			<label for="instructorFirstName">Instructor Last Name:</label>
			<input type="text" name="instructorLastName">
		</p>
		<p>
			<label for="instructorNumber">Instructor Phone #:</label>
			<input type="text" name="instructorPhoneNumber">
		</p>
		<p>
			<label for="instructorNotes">Additional Instructor Information</label>
		</p>
		<p>
			<textarea name="instructorNotes" id="instructorNotes" class="span6" rows="5"
				placeholder="Other Course Information E.g. Office hours"></textarea>
		</p>
		<table id="bookTable">
			<caption>Textbooks</caption>
			<tr>
				<th>Book Name</th>
				<th>Required</th>
			</tr>
			<tr>
				<td><input type="text" name="bookName-1"></td>
				<td><input type="checkbox" name="bookRequired-1"></td>
			</tr>
		</table>
		<button type="button" id="addBook">Add Book</button>

		<table id="gradeDistTable">
			<caption>Grade Weighting</caption>
			<tbody>
				<tr>
					<th>Course Aspect (Homework, Tests, Quizzes, etc.)</th>
					<th>Grade Weight</th>
				</tr>
				<tr>
					<td><input name="courseAspect-1" type="text"></td>
					<td><input name="gradeWeight-1" type="text"></td>
				</tr>
			</tbody>
		</table>
		<button type="button" id="gradeDistAddRow">Add Weighting</button>




		<table id="dateTable">
			<caption>Course Schedule</caption>
			<tbody>
				<tr>
					<th>Date</th>
					<th>Topic</th>
					<th>Readings/Homework/Quizzes/Tests</th>
				</tr>
				<tr>
					<td><input type="date" name="date-1"></td>
					<td><input type="text" name="topic-1"></td>
					<td><input type="text" name="assignments-1"></td>
				</tr>
			</tbody>
		</table>
		<button type="button" id="dateTableAddRow">Add Class Date</button>

		<table id="eventsTable">
			<caption>Course Special Events (E.g. Out of class tests)</caption>
			<tr>
				<th>Date</th>
				<th>Name</th>
				<th>Location</th>
			</tr>
			<tr>
				<td><input type="date" name="eventDate-1"></td>
				<td><input type="text" name="eventName-1"></td>
				<td><input type="text" name="eventLocation-1"></td>
			</tr>
		</table>
		<button type="button" id="eventsTableAddRow">Add Special Events</button>


		<p>
			<label for="courseNotes">Additional Course Information</label>
		</p>
		<p>
			<textarea name="courseNotes" id="courseNotes" class="span6" rows="5"
				placeholder="Other Course Information E.g. Policies"></textarea>
		</p>
		<p>Academic Honesty Policy:</p>
		<p>
			As a University of Georgia student, you have agreed to abide by the University&rsquo;s academic honesty policy,
			&ldquo;A Culture of Honesty,&rdquo; and the Student Honor Code. All academic work must meet the standards
			described in &ldquo;A Culture of Honesty&rdquo; found at: <a
				href="https://ovpi.uga.edu/academic-honesty/academic-honesty-policy/" target="_blank">https://ovpi.uga.edu/academic-honesty/academic-honesty-policy</a>.
			Lack of knowledge of the academic honesty policy is not a reasonable explanation for a violation. Questions
			relatedÂ to course assignments and the academic honesty policy should be directed to the instructor.
		</p>
		<p>The course syllabus is a general plan for the course; deviations announced to the class by the instructor
			may be necessary.</p>
		<input type="submit" name="submit" id="submit" value="Submit">
	</form>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.12.3.min.js"></script>
	<script src="js/jquery-ui-1.12.0-rc.1/jquery-ui.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/tableScript.js"></script>

</body>

</html>

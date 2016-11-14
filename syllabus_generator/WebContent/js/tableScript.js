$(document).ready(function(){
    var dateCounter = 1;
    var gradeCounter = 1;
    var eventsCounter = 1;
    var bookCounter = 1;
    $("#dateTableAddRow").click(function(event){
    	dateCounter++;
        event.preventDefault();

        var newRow = $('<tr><td><input type="date" name="date-' + dateCounter + '"></td><td><input type="text" name="topic-' + dateCounter + '"></td><td><input type="text" name="assignments-' + dateCounter + '"></td></tr>');
        $('#dateTable').append(newRow);

    });
    
    $("#gradeDistAddRow").click(function(event){
    	gradeCounter++;
        event.preventDefault();

        var newRow = $(' <tr><td><input name="courseAspect-' + gradeCounter + '" type="text"></td><td><input name="gradeWeight-' + gradeCounter + '" type="text"></td></tr>');
        $('#gradeDistTable').append(newRow);

    });
    $("#eventsTableAddRow").click(function(event){
    	eventsCounter++;
        event.preventDefault();

        var newRow = $(' <tr><td><input name="eventDate-' + eventsCounter + '" type="text"></td><td><input name="eventName-' + eventsCounter + '" type="text"></td><td><input type="text" name="eventLocation-' + eventsCounter + '"></td></tr>');
        $('#eventsTable').append(newRow);

    });
    
    $("#addBook").click(function(event){
    	bookCounter++;
    	event.preventDefault();
    	
    	var newRow = $('<td> <input type="text" name="bookName-' + bookCounter + '"></td><td><input type="checkbox" name="bookRequired-' + bookCounter + '"></td>');
    	$("#bookTable").append(newRow);
    });
});
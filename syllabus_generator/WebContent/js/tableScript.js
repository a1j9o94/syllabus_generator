$(document).ready(function(){
    var counter = 1;
    $("#dateTableAddRow").click(function(event){
        event.preventDefault();

        var newRow = $('<tr><th scope="col"><input type="date"></th><th><input type="text"></th><th><input type="text"></th></tr>');
            counter++;
        jQuery('#dateTable').append(newRow);

    });
});



$(document).ready(function(){
    var counter = 1;
    $("#gradeDistAddRow").click(function(event){
        event.preventDefault();

        var newRow = $(' <tr><td align="center"><input name="textfield3" type="text" id="textfield3" size="50"></td><td align="center"><input name="textfield12" type="text" id="textfield13" size="50"></td></tr>');
            counter++;
        jQuery('#gradeDistTable').append(newRow);

    });
});
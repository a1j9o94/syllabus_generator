

$(document).ready(function(){
    var counter = 1;
    $("#submit").click(function(event){
        event.preventDefault();

        var newRow = $('<tr><th scope="col"><input type="date"></th><th><input type="text"></th><th><input type="text"></th></tr>');
            counter++;
        jQuery('#dateTable').append(newRow);

    });
});

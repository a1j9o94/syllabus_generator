

$(document).ready(function(){
    var counter = 1;
    $("#submit").click(function(event){
        event.preventDefault();

        var newRow = $('<tr><th scope="col"> <input type="number" name="number"></th><th scope="col"><input type="text" name="textfield23" id="textfield23"></th><th scope="col"><input type="text" name="textfield24" id="textfield24"></th><th scope="col"><input type="text" name="textfield25" id="textfield25"></th></tr>');
            counter++;
        jQuery('#dateTable').append(newRow);

    });
});

$( document ).ready(function() {
    console.log( "ready!" );
    $.get("jsp", function(data){
        for (var id in data) {
            var contactCategory = data[id];
            $("#categories").append('<a href="#categories/' + contactCategory.id + '">' + contactCategory.name + '</a>')
        }
        /*$(".result").html(data)
        alert("Load was performed.")*/
    })
});
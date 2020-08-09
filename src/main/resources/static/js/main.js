var count = 0;

function tdclick(e) {
   /* var f = document.getElementById(e).innerHTML
    alert("hi" + "/" + e + "/ " + f)*/


        /*alert($(this.cells[e]).text());*/

    $('tr').click(function(){
        alert(this.rowIndex+1);
    });

};





$(".chosen-select").chosen({no_results_text: "Oops, nothing found!"});


/*function Selected(a) {
    var label = a.value;
    if (label === 'teacher') {
        document.getElementById("spec").style.display = 'block';
    } else {
        document.getElementById("spec").style.display = 'none';
    }
}*/

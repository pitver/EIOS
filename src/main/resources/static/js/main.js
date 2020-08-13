function tdclick(e, dataNewGrade, studentId) {
    /*alert(u)*/
    let cell = event.target;
    if (cell.tagName.toLowerCase() != 'td')
        return;
    let i = cell.parentNode.rowIndex;
    let j = cell.cellIndex;
    var row = $("table tr").eq(i);
    var cells = $("td", row).eq(j);


    if (cells[0].innerText === "") {
        $(document).ready(function () {
            var new_window =  window.open("addmark","width=500,height=500");
            new_window.onload = function() {
                /*new_window.document.getElementById('gradedata').innerHTML = "07.08.2020";*/
                new_window.document.getElementById('studentid').value = studentId;
            }


                /*$('#myModal').modal("show");
                $('#myModal .grade').hide();
                $('#myModal .addmark').show();
                $('#myModal .btnGrade').show();*/
           /* $('#addmark .gradedata').val(dataNewGrade);
            $('#addmark .studentid').val(studentId);*/

            /*$('#myModal .gradedata').val(dataNewGrade);
            $('#myModal .studentid').val(studentId);*/

        });

    } else {
        $(document).ready(function () {
            $('#myModal').modal("show");
            $('#myModal .grade').val(cells[0].innerText).show();
            $('#myModal .addmark').hide();
            $('#myModal .btnGrade').hide();

        });


    }



}
;

function tdload(e) {
    alert(e)

}


$(".chosen-select").chosen({no_results_text: "Oops, nothing found!"});


/*function Selected(a) {
    var label = a.value;
    if (label === 'teacher') {
        document.getElementById("spec").style.display = 'block';
    } else {
        document.getElementById("spec").style.display = 'none';
    }
}*/

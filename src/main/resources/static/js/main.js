function tdclick(e, dataNewGrade,studentId) {
    /*alert(u)*/
    let cell = event.target;
    if (cell.tagName.toLowerCase() != 'td')
        return;
    let i = cell.parentNode.rowIndex;
    let j = cell.cellIndex;
    var row = $("table tr").eq(i);
    var cells = $("td", row).eq(j);


    var s = cells.text()
    alert(s.length)
    if (typeof s === "undefined" || s === null || s === "" || s.length === 40) {
        $(document).ready(function () {
            $('#myModal').modal("show");
            $('#myModal .grade').hide();
            $('#myModal .addmark').show();
            $('#myModal .btnGrade').show();
            $('#myModal .gradedata').val(dataNewGrade);
            $('#myModal .studentid').val(studentId);

        });

    } else {
        $(document).ready(function () {
            $('#myModal').modal("show");
            $('#myModal .grade').val(cells.text()).show();
            $('#myModal .addmark').hide();
            $('#myModal .btnGrade').hide();

        });


    }


};

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

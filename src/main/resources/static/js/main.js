function tdclick(e, currentDate, dataGrade, studentId,currentUser) {
    /*alert(u)*/
    let cell = event.target;
    if (cell.tagName.toLowerCase() != 'td')
        return;
    let i = cell.parentNode.rowIndex;
    let j = cell.cellIndex;
    var row = $("table tr").eq(i);
    var cells = $("td", row).eq(j);


    if ((cells[0].innerText === "")&&!(currentUser.indexOf('[STUDENT]'))){

    } else if((cells[0].innerText === "")){
        $(document).ready(function () {

            $('#myModal').modal("show");
            $('#myModal .grade').hide();
            $('#myModal .addmark').show();
            $('#myModal .btnGrade').show();
            if( dataGrade >= 0 && dataGrade <= 9) {
                num= "0" + dataGrade;
            }
            else {
                num= "" + dataGrade;
            }
            var dateNewGrade=(currentDate.substr(0,currentDate.length-2)+num)
            $('#myModal .gradedata').val(dateNewGrade);
            $('#myModal .studentid').val(studentId);
        });
    }else{$(document).ready(function () {
        $('#myModal').modal("show");
        $('#myModal .grade').val(cells[0].innerText).show();
        $('#myModal .addmark').hide();
        $('#myModal .btnGrade').hide();

    });}


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

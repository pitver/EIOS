function tdclick(e,u) {
    alert(u)
    let cell = event.target;
    if (cell.tagName.toLowerCase() != 'td')
        return;
    let i = cell.parentNode.rowIndex;
    let j = cell.cellIndex;
    var row = $("table tr").eq(i);
    var cells = $("td", row).eq(j);

    $(document).ready(function () {

        $('#myModal').modal("show");
        $('#myModal .grade').val(cells.text());

    });
    /*if (cells.text().textContent===undefined) {
        alert("add grade")

    } else {
        $(document).ready(function () {

            $('#myModal').modal("show");
            $('#myModal .grade').val(cells.text());

        });


    }*/


};
function tdload(e){
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

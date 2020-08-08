$(document).ready(function() {
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь','Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
        monthNamesShort: ['Янв.','Фев.','Март','Апр.','Май','Июнь','Июль','Авг.','Сент.','Окт.','Ноя.','Дек.'],
        dayNames: ["Воскресенье","Понедельник","Вторник","Среда","Четверг","Пятница","Суббота"],
        dayNamesShort: ["ВС","ПН","ВТ","СР","ЧТ","ПТ","СБ"],
        buttonText: {
            today: "Сегодня",
            month: "Месяц",
            week: "Неделя",
            day: "День"
        },
        defaultDate: '2020-08-08',
        editable: true,
        eventLimit: true,
        events: {
            url: '/allevents',
            type: 'GET',
            data: {
                start: 'start',
                id: 'id',
                title: 'title,'
            },
            error: function() {
                alert('there was an error while fetching events!');
            },
        },
        selectable: true,
        selectHelper: true,
        select: function(start, end) {
            startdateandtime.value = moment(start).format("YYYY-MM-DDTHH:mm:ss");
            enddateandtime.value = moment(end).format("YYYY-MM-DDTHH:mm:ss");
            dialog.dialog( "open" );
        }
    });
});
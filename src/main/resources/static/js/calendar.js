
    $(document).ready(function() {
        var form = $('#exampleModal');

        /* режимы открытия формы */
      function formOpen(mode) {
         if (mode == 'addevent') {
             form.modal("show");
         }
        }

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
        events: function (start, end, timezone, callback) {
                $.ajax({
                    type: "GET",
                    url: "/events",
                    dataType: "json",
                    data: {
                        start: start.toLocaleString("yyyy-mm-dd"),
                        end: end.toLocaleString("yyyy-mm-dd")
                    },
                    error: function (xhr, type, exception) {
                        alert("Error: " + exception);
                    },
                    success:  function(doc) {
                        var events = [];
                        $.each(doc, function (i, v) {
                            events.push({
                                title: v.eventName,
                                start: moment(v.startDateTime)
                            });
                        });
                        callback(events);
                        console.log(doc);
                    }
                });
            },
        selectable: true,
        selectHelper: true,
            select: function(start, end) {
                // Display the modal.
                // You could fill in the start and end fields based on the parameters
                formOpen('addevent');

            },
            eventClick: function(event, element) {
            // Display the modal and set the values to the event values.
            $('.modal').modal('show');
/*            $('.modal').find('#title').val(event.title);
            $('.modal').find('#starts-at').val(event.start);
            $('.modal').find('#ends-at').val(event.end);*/
        }

    });
});
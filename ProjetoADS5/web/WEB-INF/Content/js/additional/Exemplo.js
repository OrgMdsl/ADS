$(document).ready(function () {
    $.ajax({
        url: "ExibeExemplo?id=1",
        dataType: "json",
        success: function (item) {
            alert(item.id + " - " + item.nome);
        },
        error: function (er) {
            $('html').html(er.responseText);
        }
    });
});

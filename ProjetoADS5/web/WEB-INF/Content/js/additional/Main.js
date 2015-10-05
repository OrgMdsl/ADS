
function ajax(url, sucesso, erro)
{

    $.ajax({
        url: url,
        dataType: "json",
        success: function (item) {
            debugger;
            sucesso(item);
        },
        error: function (er) {
            erro(er);
        }
    });
}

function modal(data)
{
    debugger;
    var html = "<div class=\"modal fade\" id=\"modalMsg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">" +
            "    <div class=\"modal-dialog\" role=\"document\">" +
            "        <div class=\"modal-content\">" +
            "            <div class=\"modal-header\">" +
            "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
            "                <h4 class=\"modal-title\" id=\"myModalLabel\">" + data.titulo + "</h4>" +
            "            </div>" +
            "            <div class=\"modal-body\">" +
                                data.corpo +
            "            </div>" +
            "            <div class=\"modal-footer\">" +
            "                <button type=\"button\" class=\"btn btn-primary\" onclick=\"\">Ok</button>" +
            "                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Cancelar</button>" +
            "            </div>" +
            "        </div>" +
            "    </div>" +
            "</div>";
    
    $('body').append(html);
    $("#modalMsg").modal("show");
}
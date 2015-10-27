/* global Ajax, Util, Const, Componente */
//Classe
var AjaxHelper = (function () {

    //Construtor
    function AjaxHelper() {
    }

    AjaxHelper.Post = function (action, autenticacao, atributos, data, callbackSucesso, callbackErro) {
        Componente.Loading.Show();

        if (Util.IsEmpty(action))
            return null;

        if (Util.IsNull(autenticacao))
            autenticacao = false;

        if (Util.IsNull(atributos))
            atributos = "";

        var restrito = autenticacao ? Const.AccessControl.RESTRITO : "";

        var url = action + restrito + "?" + atributos;
        $.ajax({
            url: url,
            type: 'POST',
            async: false,
            cache: false,
            contentType: "application/json; charset=utf-8",
            processData: false,
            data: data,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                callbackSucesso(data);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                callbackErro(jqXHR);
                Componente.Loading.Remove();
            }
        });
    };

    var private = {
    };

    return AjaxHelper;
}());
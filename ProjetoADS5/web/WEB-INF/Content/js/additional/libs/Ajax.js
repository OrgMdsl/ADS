//Classe
var Ajax = (function () {

    //Construtor
    function Ajax() {
        alert("Ajax!");
    }

    /**
     * Função para executar requisições Ajax.
     * 
     * @example 
     *   Ajax.Post("ModalAtencao", false, "corpo=Teste",
            function (data) {
                modal(data);
            },
            function (data) {
                alert(data.responseText);
            }
         );
     * 
     * @param   {String} action   Parametro obrigatório. Nome do Controller que efetuará a ação
     * @param   {Bool} autenticacao    Parametro obrigatório. Exige autenticação?
     * @param   {String} atributos    Parametro opcional. Atributos concatenados (Se possuir), Ex.: "id=1&nome=teste"
     * @param   {Função Callback} callbackSucesso    Parametro opcional. Recebe o retorno caso haja sucesso
     * @param   {Função Callback} callbackErro    Parametro opcional. Recebe o retorno se houver erro
     * @param   {Object} formData    Parametro opcional. Recebe os dados de um formulário ao realizar o submit. Ex.: formData = new FormData($("#MeuFormulario")[0]);
     * @returns {}
     */
    Ajax.Post = function (action, autenticacao, atributos, callbackSucesso, callbackErro, formData) {
        if (Util.IsEmpty(action))
            return null;

        if (Util.IsNull(autenticacao))
            autenticacao = false;

        if (Util.IsNull(atributos))
            atributos = "";

        var restrito = autenticacao ? Const.AccessControl.RESTRITO : "";

        var url = action + restrito + "?" + atributos;

        if (!Util.IsEmpty(formData))
        {
            $.ajax({
                url: url,
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                dataType: 'json',
                success: function (item) {
                    callbackSucesso(item);
                },
                error: function (er) {
                    callbackErro(er);
                }
            });
        }
        else
        {
            $.ajax({
                url: url,
                type: 'POST',
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                dataType: 'json',
                success: function (item) {
                    callbackSucesso(item);
                },
                error: function (er) {
                    callbackErro(er);
                }
            });
        }
    };

    //Privado
    var private = {
    };

    return Ajax;
}());
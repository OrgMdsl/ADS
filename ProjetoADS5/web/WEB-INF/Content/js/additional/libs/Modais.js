
/* global Componente, Util */

var Modais = (function () {

    function Modais() {
    }

    Modais.Get = {
        Aviso: function (conteudo, okCallback, cancelarCallback) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idOk = idModal + "_ok";
            var idCancelar = idModal + "_cancelar";

            botoes.push(Componente.Botoes.Ok("", idOk));
            botoes.push(Componente.Botoes.Cancelar("", idCancelar));

            var html = montaModal("Aviso", conteudo, botoes, idModal);
            $("body").append(html);

            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            $("#" + idOk).on("click", function (data) {
                if (!Util.IsNull(okCallback))
                    okCallback(cb);
                else
                    fecharModal(cb.idModal);
            });

            $("#" + idCancelar).on("click", function (data) {
                if (!Util.IsNull(cancelarCallback))
                    cancelarCallback(cb);
                else
                    fecharModal(cb.idModal);
            });

            return $("#" + idModal);
        },
        Erro: function (conteudo, fecharCallback) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idFechar = idModal + "_fechar";
            botoes.push(Componente.Botoes.Fechar("", idFechar));
            var html = montaModal("Erro", conteudo, botoes, idModal);
            $("body").append(html);

            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            $("#" + idFechar).on("click", function (data) {
                if (!Util.IsNull(fecharCallback))
                    fecharCallback(cb);
                else
                    fecharModal(cb.idModal);
            });
            return $("#" + idModal);
        },
        Confirmacao: function (conteudo, simCallback, naoCallback) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idSim = idModal + "_sim";
            var idNao = idModal + "_nao";

            botoes.push(Componente.Botoes.Sim("", idSim));
            botoes.push(Componente.Botoes.Nao("", idNao));

            var html = montaModal("Atenção", conteudo, botoes, idModal);
            $("body").append(html);

            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            $("#" + idSim).on("click", function (data) {
                if (!Util.IsNull(simCallback))
                    simCallback(cb);
                else
                    fecharModal(cb.idModal);
            });

            $("#" + idNao).on("click", function (data) {
                if (!Util.IsNull(naoCallback))
                    naoCallback(cb);
                else
                    fecharModal(cb.idModal);
            });

            return $("#" + idModal);
        },
        Basica: function (conteudo, okCallback) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idOk = idModal + "_ok";

            botoes.push(Componente.Botoes.Ok("", idOk));

            var html = montaModal("<i class='fa fa-exclamation-triangle orange'></i>", conteudo, botoes, idModal);
            $("body").append(html);

            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            $("#" + idOk).on("click", function (data) {
                if (!Util.IsNull(okCallback))
                    okCallback(cb);
                else
                    fecharModal(cb.idModal);
            });
            
            return $("#" + idModal);
        }
    };

    function callbackBtn() {
        callbackBtn.idModal;
    }

    function montaModal(titulo, corpo, botoes, id)
    {
        var html = "<div class=\"modal fade\" id=\"" + id + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">" +
                "    <div class=\"modal-dialog\" role=\"document\">" +
                "        <div class=\"modal-content\">" +
                "            <div class=\"modal-header\">" +
                "                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>" +
                "                <h4 class=\"modal-title\" id=\"myModalLabel\">" + titulo + "</h4>" +
                "            </div>" +
                "            <div class=\"modal-body\">" +
                corpo +
                "            </div>" +
                "            <div class=\"modal-footer\">";
        for (var i = 0; i < botoes.length; i++) {
            html += botoes[i];
        }
        ;
        html += "            </div>" +
                "        </div>" +
                "    </div>" +
                "</div>";

        return html;
    }

    return Modais;
}());
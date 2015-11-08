
/* global Componente, Util */

var Modais = (function () {

    function Modais() {
    }

    Modais.Get = {
        Aviso: function (conteudo, okOnclick, cancelarOnclick) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idOk = idModal + "_ok";
            var idCancelar = idModal + "_cancelar";

            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            if (Util.IsNull(okOnclick))
                okOnclick = "fecharModal('" + cb.idModal + "')";
            if (Util.IsNull(cancelarOnclick))
                cancelarOnclick = "fecharModal('" + cb.idModal + "')";
            
            botoes.push(Componente.Botoes.Ok(okOnclick, idOk));
            botoes.push(Componente.Botoes.Cancelar(cancelarOnclick, idCancelar));

            var html = montaModal("Aviso", conteudo, botoes, idModal);
            $("body").append(html);

            return $(cb.idModal);
        },
        Erro: function (conteudo, fecharOnclick) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idFechar = idModal + "_fechar";
            
            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            if (Util.IsNull(fecharOnclick))
                fecharOnclick = "fecharModal('" + cb.idModal + "')";
            
            botoes.push(Componente.Botoes.Fechar(fecharOnclick, idFechar));
            var html = montaModal("Erro", conteudo, botoes, idModal);
            $("body").append(html);

            return $(cb.idModal);
        },
        Confirmacao: function (conteudo, simOnclick, naoOnclick) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idSim = idModal + "_sim";
            var idNao = idModal + "_nao";
            
            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

                simOnclick += ";fecharModal('" + cb.idModal + "')";
            if (Util.IsNull(naoOnclick))
                naoOnclick += ";fecharModal('" + cb.idModal + "')";
            
            botoes.push(Componente.Botoes.Sim(simOnclick, idSim));
            botoes.push(Componente.Botoes.Nao(naoOnclick, idNao));

            var html = montaModal("Atenção", conteudo, botoes, idModal);
            $("body").append(html);

            return $(cb.idModal);
        },
        Basica: function (conteudo, okOnclick) {
            var botoes = new Array();
            var idModal = "modal_" + getNumero();
            var idOk = idModal + "_ok";

            var cb = new callbackBtn();
            cb.idModal = "#" + idModal;

            if (Util.IsNull(okOnclick))
                okOnclick = "fecharModal('" + cb.idModal + "')";

            botoes.push(Componente.Botoes.Ok(okOnclick, idOk));

            var html = montaModal("<i class='fa fa-exclamation-triangle orange'></i>", conteudo, botoes, idModal);
            $("body").append(html);
            
            $("#" + idModal).modal("show");
            
            return $(cb.idModal);
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
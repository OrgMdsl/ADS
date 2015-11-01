/* global Util, Componente, AjaxHelper, CircularJSON, Modais */

var isEdicao = false;

$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenOperacao").val()) ? false : true;

    CadastrarGenerico.load();

});

function GenericoDto() {
    GenericoDto.nome;
    GenericoDto.descricao;
    GenericoDto.genericoItems;
    GenericoDto.ativo;
}

function GenericoItemDto() {
    GenericoItemDto.descricao;
    GenericoItemDto.sigla;
    GenericoItemDto.ativo;
    GenericoItemDto.generico;
}

var CadastrarGenerico = (function () {

    var tabelaDT = null;
    var tabela = null;
    var siglas = new Array();

    function CadastrarGenerico() {
    }

    CadastrarGenerico.load = function () {
        tabela = $('#listagem-GenericoItem');
        tabelaDT = tabela.DataTable({
            columns: [
                {
                    width: '40%',
                    title: 'Descrição'
                },
                {
                    width: '40%',
                    title: 'Sigla'
                },
                {
                    width: '20%',
                    title: 'Ações'
                }
            ]
        });

        $("#acoesFormulario").append(
                Componente.Botoes.Salvar("", "btn-salvar") +
                Componente.Botoes.Cancelar("javascript:window.history.back()", "")
                );

        $('#btn-add-item').on('click', function () {
            validaAddItem();
        });
        $("#btn-salvar").on('click', function () {
            salvar();
        });

        eventoExcluirItem(tabela, tabelaDT);
    };

    function validaAddItem() {
        var validacoes = new Array();
        var sigla = $("#itemSigla");
        var descricao = $("#itemDescricao");

        if (Util.IsEmpty(sigla.val())) {
            Util.InputColor.Vermelho(sigla);
            validacoes.push("Digite uma sigla;");
        }
        if (Util.IsEmpty(descricao.val())) {
            Util.InputColor.Vermelho(descricao);
            validacoes.push("Digite uma Descrição;");
        }

        if (!Util.IsEmpty(sigla.val())) {
            var idx = tabelaDT
                    .columns()
                    .data()
                    .eq(0) // Reduce the 2D array into a 1D array of data
                    .indexOf(sigla.val());

            if (idx !== -1) {
                Util.InputColor.Vermelho(sigla);
                validacoes.push("A sigla ' " + sigla.val().toUpperCase() + " ' já foi adicionada.");
            }
        }

        if (validacoes.length > 0) {
            var mensagem = "<span class='mensagem_modal_erro red'><b>Preencha os campos corretamente:</b><br/><br/>";
            for (var i = 0; i < validacoes.length; i++) {
                mensagem += "- " + validacoes[i] + "<br/>";
            }
            mensagem += "</span>";

            Modais.Get.Erro(mensagem, function (obj) {
                fecharModal(obj.idModal);
            }).modal("show");
            return false;
        }

        tabelaDT.row.add([
            $("#itemDescricao").val(),
            $("#itemSigla").val().toUpperCase(),
            Componente.Icones.Editar("") +
                    Componente.Icones.Desativar("item_" + getNumero()) +
                    Componente.Icones.Excluir("")
        ]).draw(false);
        siglas.push(sigla.val());
        $("#itemSigla").val("");
        $("#itemDescricao").val("");
    }

    function salvar() {
        Componente.Loading.Show();

        var ListaGenericoItemDto = new Array();

        var objeto = new GenericoDto();
        objeto.nome = $('#nome').val();
        objeto.descricao = $('#descricao').val();
        objeto.genericoItems = null; //Impedir referencia circular
        objeto.ativo = true;

        //Impede referencia circular
        var objetoAux = new GenericoDto();
        objetoAux = jQuery.extend(true, {}, objeto);

        for (var i = 1; i <= tabelaDT.rows().data().length; i++) {
            var item = new GenericoItemDto();
            item.descricao = $("table tr:nth-child(" + i + ") td").eq(0).html();
            item.sigla = $("table tr:nth-child(" + i + ") td").eq(1).html();
            item.ativo = Util.HasClass($("table tr:nth-child(" + i + ") td").eq(2).children(".ico_muda_status")[0], "ativo");
            item.generico = objetoAux;
            ListaGenericoItemDto.push(item);
        }

        objeto.genericoItems = ListaGenericoItemDto;

        var obj = JSON.stringify(objeto);

        AjaxHelper.Post("CadastrarGenerico", true, null, obj,
                function (sucesso) {
                    Componente.Loading.Remove();
                    Modais.Get.Basica(sucesso.responseText);
                },
                function (erro) {
                    Componente.Loading.Remove();
                    Modais.Get.Basica(erro.responseText);
                });
    }

    return CadastrarGenerico;
}());


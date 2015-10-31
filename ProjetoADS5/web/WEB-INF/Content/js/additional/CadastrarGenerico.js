/* global Util, Componente, AjaxHelper */

var isEdicao = false;

$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenOperacao").val()) ? false : true;
    
    CadastrarGenerico.load();

});

function GenericoDto(nome, descricao, genericoItems, ativo) {
    this.nome = nome;
    this.descricao = descricao;
    this.genericoItems = genericoItems;
    this.ativo = ativo;
}

function GenericoItemDto(descricao, sigla, ativo) {
    this.descricao = descricao;
    this.sigla = sigla;
    this.ativo = ativo;
}

var CadastrarGenerico = (function () {

    var tabelaDT = null;
    var tabela = null;

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
        if (Util.IsEmpty($("#itemSigla").val())) {
            alert("Não pode ficar em branco");
            return false;
        }
        if (Util.IsEmpty($("#itemDescricao").val())) {
            alert("Não pode ficar em branco");
            return false;
        }
        tabelaDT.row.add([
            $("#itemDescricao").val(),
            $("#itemSigla").val().toUpperCase(),
            Componente.Icones.Editar("") +
                    Componente.Icones.Desativar("item_" + getNumero()) +
                    Componente.Icones.Excluir("")
        ]).draw(false);
        $("#itemSigla").val("");
        $("#itemDescricao").val("");
    }

    function salvar() {
        Componente.Loading.Show();

        var ListaGenericoItemDto = new Array();

        for (var i = 1; i <= tabelaDT.rows().data().length; i++) {

            var item = new GenericoItemDto(
                    $("table tr:nth-child(" + i + ") td").eq(0).html(),
                    $("table tr:nth-child(" + i + ") td").eq(1).html(),
                    Util.HasClass($("table tr:nth-child(" + i + ") td").eq(2).children(".ico_muda_status")[0], "ativo")
                    );

            ListaGenericoItemDto.push(item);
        }

        var objeto = new GenericoDto(
                $('#nome').val(),
                $('#descricao').val(),
                ListaGenericoItemDto,
                true
                );

        var obj = JSON.stringify(objeto);

        Componente.Loading.Remove();

        AjaxHelper.Post("CadastrarGenerico", true, null, obj,
                function (sucesso) {
                    modal("Atenção", sucesso.responseText);
                },
                function (erro) {
                    modal("Atenção", erro.responseText);
                });
    }

    return CadastrarGenerico;
}());


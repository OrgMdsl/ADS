/* global Util, Componente, AjaxHelper, CircularJSON, Modais, Const */

var isEdicao = false;
var tabelaDT = null;
$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenId").val()) ? false : true;

    CadastrarGenerico.load();

});

function GenericoDto() {
    GenericoDto.id = null;
    GenericoDto.nome;
    GenericoDto.descricao;
    GenericoDto.genericoItems;
    GenericoDto.ativo;
}

function GenericoItemDto() {
    GenericoItemDto.descricao;
    GenericoItemDto.titulo;
    GenericoItemDto.ativo;
    GenericoItemDto.generico;
}

var CadastrarGenerico = (function () {


    var tabela = null;
    var titulos = new Array();

    function CadastrarGenerico() {
    }

    CadastrarGenerico.load = function () {
        tabela = $('#listagem-GenericoItem');
        if (isEdicao)
        {
            AjaxHelper.PostSimple("BuscarGenerico", false, "id=" + $("#hiddenId").val(),
                    function (data) {
                        $("#nome").val(data.nome);
                        $("#descricao").val(data.descricao);
                        $("#ativo").attr("checked", data.ativo);
                        tabelaDT = TabelaEdicao(tabela, data);
                        Componente.Loading.Remove();
                    },
                    function (erro) {
                        Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + erro.responseText);
                        Componente.Loading.Remove();
                    });
        }
        else
        {
            tabelaDT = TabelaCadastro(tabela);
        }

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

        tabela.on(
                'click',
                '.excluir',
                function () {
                    var row = $(this).parents('tr');
                    tabelaDT
                            .row(row)
                            .remove()
                            .draw();
                });
    };

    function validaAddItem() {
        var validacoes = new Array();
        var titulo = $("#itemTitulo");
        var descricao = $("#itemDescricao");

        if (Util.IsEmpty(titulo.val())) {
            Util.InputColor.Vermelho(titulo);
            validacoes.push("Digite um Título;");
        }
        if (Util.IsEmpty(descricao.val())) {
            Util.InputColor.Vermelho(descricao);
            validacoes.push("Digite uma Descrição;");
        }

        if (!Util.IsEmpty(titulo.val())) {
            var idx = tabelaDT
                    .columns()
                    .data()
                    .eq(0) // Reduce the 2D array into a 1D array of data
                    .indexOf(titulo.val());

            if (idx !== -1) {
                Util.InputColor.Vermelho(titulo);
                validacoes.push("O título ' " + titulo.val().toUpperCase() + " ' já foi adicionado.");
            }
        }

        if (validacoes.length > 0) {
            var mensagem = "<span class='mensagem_modal_erro red'><b>Preencha os campos corretamente:</b><br/><br/>";
            for (var i = 0; i < validacoes.length; i++) {
                mensagem += "- " + validacoes[i] + "<br/>";
            }
            mensagem += "</span>";

            Modais.Get.Erro(mensagem, "").modal("show");
            return false;
        }
        debugger;
        tabelaDT.row.add(
                {
                    "descricao": $("#itemDescricao").val(),
                    "titulo": $("#itemTitulo").val(),
                    "acoes": Componente.Icones.Editar("") +
                            Componente.Icones.Desativar("item_" + getNumero()) +
                            Componente.Icones.Excluir("")
                }
        ).draw();
        titulos.push(titulo.val());
        $("#itemTitulo").val("");
        $("#itemDescricao").val("");
    }

    CadastrarGenerico.excluirItem = function (item) {
        var row = $(item).parents('tr');
        tabelaDT
                .row(row)
                .remove()
                .draw();
    };

    function salvar() {
        Componente.Loading.Show();

        var ListaGenericoItemDto = new Array();

        var objeto = new GenericoDto();
        if (isEdicao)
            objeto.id = $("#hiddenId").val();
        objeto.nome = $('#nome').val();
        objeto.descricao = $('#descricao').val();
        objeto.genericoItems = null; //Impedir referencia circular
        objeto.ativo = $('#ativo').is(":checked");

        //Impede referencia circular
        var objetoAux = new GenericoDto();
        objetoAux = jQuery.extend(true, {}, objeto);

        if (!isEdicao) {
            for (var i = 1; i <= tabelaDT.rows().data().length; i++) {
                var item = new GenericoItemDto();
                item.descricao = $("table tr:nth-child(" + i + ") td").eq(0).html();
                item.titulo = $("table tr:nth-child(" + i + ") td").eq(1).html();
                item.ativo = Util.HasClass($("table tr:nth-child(" + i + ") td").eq(2).children(".ico_muda_status")[0], "ativo");
                item.generico = objetoAux;
                ListaGenericoItemDto.push(item);
            }
        }
        else
        {
            for (var i = 1; i <= tabelaDT.rows().data().length; i++) {
                var item = new GenericoItemDto();
                item.descricao = $("table tr:nth-child(" + i + ") td input").eq(0).val();
                item.titulo = $("table tr:nth-child(" + i + ") td input").eq(1).val();
                item.ativo = Util.HasClass($("table tr:nth-child(" + i + ") td").eq(2).children(".ico_muda_status")[0], "ativo");
                item.generico = objetoAux;
                ListaGenericoItemDto.push(item);
            }
        }

        objeto.genericoItems = ListaGenericoItemDto;

        var obj = JSON.stringify(objeto);

        AjaxHelper.Post("CadastrarGenerico", true, null, obj,
                function (sucesso) {
                    Componente.Loading.Remove();
                    Modais.Get.Basica(sucesso.responseText, "abrirPaginaSemRefresh(window.location);");
                },
                function (erro) {
                    Componente.Loading.Remove();
                    Modais.Get.Basica(erro.responseText, "abrirPaginaSemRefresh(window.location);");
                });
    }


    function TabelaCadastro(tabela) {
        return tabela.DataTable({
            columns: [
                {
                    width: '40%',
                    title: 'Descrição',
                    data:  'descricao'
                },
                {
                    width: '40%',
                    title: 'Titulo',
                    data:  'titulo'
                },
                {
                    width: '20%',
                    title: 'Ações',
                    data:  'acoes'
                }
            ]
        });
    }

    function TabelaEdicao(tabela, dados) {
        return tabela.DataTable({
            "data": dados.genericoItems,
            "deferRender": true,
            "columns": [
                {
                    "title": "Descrição",
                    "data": "descricao",
                    "width": "40%",
                    "render": function (data) {
                        return Componente.Input.Textbox(data, null, "style='width: 100%; font-size: small; padding: 2px;' ");
                    }
                },
                {
                    "width": '40%',
                    "title": 'Título',
                    "data": "titulo",
                    "render": function (data) {
                        return Componente.Input.Textbox(data, null, "style='width: 100%; font-size: small; padding: 2px;' ");
                    }
                },
                {
                    "title": "Ações",
                    "width": "20%",
                    "data": "acoes",
                    "render": function (data, type, row) {
                        return montaAcoes(row);
                    }
                }
            ]
        });
    }

    function montaAcoes(row) {
        if (!Util.IsNull(row)) {
            var c = "";

            c += Componente.Icones.Visualizar("javascript:CadastrarGenerico.visualizarConteudo(" + row.id + ")");

            if (!row.ativo)
                c += Componente.Icones.Ativar("", "AlterarStatusGenerico" + Const.AccessControl.RESTRITO + "?id=" + row.id);
            else
                c += Componente.Icones.Desativar("", "AlterarStatusGenerico" + Const.AccessControl.RESTRITO + "?id=" + row.id);
            return c;
        }
        return Const.Messages.ERRO_1;
    }


    CadastrarGenerico.visualizarConteudo = function (id) {
        Componente.Loading.Show();
        $.ajax({
            url: "BuscarGenericoItem?id=" + id,
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                Modais.Get.Basica("Titulo: " + data.titulo + "<br><br> Descrição: <br>" + data.descricao).modal("show");
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Erro ao carregar informações.").modal("show");
                Componente.Loading.Remove();
            }
        });
    };

    return CadastrarGenerico;
}());


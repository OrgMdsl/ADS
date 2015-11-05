/* global Util, Componente, AjaxHelper, CircularJSON, Modais, Const */

var isEdicao = false;

$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenId").val()) ? false : true;

    CadastrarGenerico.load();

});

function DisciplinaDto() {
    DisciplinaDto.id = null;
    DisciplinaDto.nome;
    DisciplinaDto.descricao;
    DisciplinaDto.genericoItems;
    DisciplinaDto.ativo;
}

var CadastrarDisciplina = (function () {

    var tabelaDT = null;
    var tabela = null;

    function CadastrarDisciplina() {
    }

    CadastrarDisciplina.load = function () {
        tabela = $('#listagem-Disciplina');


        AjaxHelper.PostSimple("BuscarDisciplina", false, "id=" + $("#hiddenId").val(),
                function (data) {
                    $("#nome").val(data.nome);

                    tabelaDT = TabelaEdicao(tabela, data);
                    Componente.Loading.Remove();
                },
                function (erro) {
                    Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + erro.responseText);
                    Componente.Loading.Remove();
                });


        $("#acoesFormulario").append(
                Componente.Botoes.Salvar("", "btn-salvar") +
                Componente.Botoes.Cancelar("javascript:window.history.back()", "")
                );


        $("#btn-salvar").on('click', function () {
            validaAddItem(function () {
                salvar();
            });

        });

        eventoExcluirItem(tabela, tabelaDT);
    };

    function validaAddItem(callback) {
        var validacoes = new Array();
        var nome = $("#nome");


        if (Util.IsEmpty(nome.val())) {
            Util.InputColor.Vermelho(nome);
            validacoes.push("Digite um nome;");
        }


        //aqui monta uma string para mostrar na tela os erros.
        if (validacoes.length > 0) {
            var mensagem = "<span class='mensagem_modal_erro red'><b>Preencha os campos corretamente:</b><br/><br/>";
            for (var i = 0; i < validacoes.length; i++) {
                mensagem += "- " + validacoes[i] + "<br/>";
            }
            mensagem += "</span>";

            //mostra a mensagem de erro na tela.
            Modais.Get.Erro(mensagem, function (obj) {
                fecharModal(obj.idModal);
            }).modal("show");
            return false;
        }

        callback();
    }

    function salvar() {
        Componente.Loading.Show();

        var objeto = new GenericoDto();
        if (isEdicao)
            objeto.id = $("#hiddenId").val();
        objeto.nome = $('#nome').val();

        objeto.genericoItems = null; //Impedir referencia circular
        objeto.ativo = $('#ativo').is(":checked");

        //Impede referencia circular
        var objetoAux = new GenericoDto();
        objetoAux = jQuery.extend(true, {}, objeto);

        if (!isEdicao) {
            for (var i = 1; i <= tabelaDT.rows().data().length; i++) {
                var item = new GenericoItemDto();
                item.descricao = $("table tr:nth-child(" + i + ") td").eq(0).html();
                item.sigla = $("table tr:nth-child(" + i + ") td").eq(1).html();
                item.ativo = Util.HasClass($("table tr:nth-child(" + i + ") td").eq(2).children(".ico_muda_status")[0], "ativo");
                item.generico = objetoAux;
                ListaGenericoItemDto.push(item);
            }
        }
        else
        {
            debugger;
            for (var i = 1; i <= tabelaDT.rows().data().length; i++) {
                var item = new GenericoItemDto();
                item.descricao = $("table tr:nth-child(" + i + ") td input").eq(0).val();
                item.sigla = $("table tr:nth-child(" + i + ") td input").eq(1).val();
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
                    Modais.Get.Basica(sucesso.responseText);
                },
                function (erro) {
                    Componente.Loading.Remove();
                    Modais.Get.Basica(erro.responseText);
                });
    }

    function TabelaEdicao(tabela, dados) {
        return tabela.DataTable({
            "data": dados,
            "deferRender": true,
            "columns": [
                {
                    "title": "Nome da Disciplina",
                    "data": "nome",
                    "width": "80%",
                    "render": function (data) {
                        return Componente.Input.Textbox(data);
                    }
                },
                {
                    "title": "Ações",
                    "width": "20%",
                    "render": function (data, type, row) {
                        return montaAcoes(row);
                    }
                }
            ]
        });
    }

    function montaAcoes(row) {
        if (!Util.IsNull(row)) {
            var c = Componente.Icones.Excluir("javascript:CadastrarDisciplina.excluirDisciplina("+row.id+")","");
            return c;
        }
        return Const.Messages.ERRO_1;
    }

    CadastrarDisciplina.excluirDisciplina = function(id) {
        Modais.Get.Confirmacao("Deseja realmente excluir este item?", function (obj) {

            AjaxHelper.PostSimple("ExcluirDisciplina", false, "id=" + id,
                    function (data) {
                        Modais.Get.Aviso("Excluído com sucesso!");
                        Componente.Loading.Remove();
                    },
                    function (erro) {
                        Modais.Get.Erro("Erro ao excluir! Detalhes: <br><br>" + erro.responseText);
                        Componente.Loading.Remove();
                    });

        }, function (obj) {
            fecharModal(obj.idModal);
        }).modal("show");
    }

    return CadastrarGenerico;
}());


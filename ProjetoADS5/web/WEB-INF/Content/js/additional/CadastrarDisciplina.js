/* global Util, Componente, AjaxHelper, CircularJSON, Modais, Const */

var isEdicao = false;
var hiddenId;
var nome;
var tabelaDT;
var tabela;

$(document).ready(function () {
    hiddenId = $("#hiddenId");
    nome = $("#nome");
    isEdicao = Util.IsEmpty(hiddenId.val()) ? false : true;

    CadastrarDisciplina.load(function () {

        CadastrarDisciplina.carregarTabela(null);

    });
});

function DisciplinaDto() {
    DisciplinaDto.id;
    DisciplinaDto.nome;
}

var CadastrarDisciplina = (function () {

    function CadastrarDisciplina() {
    }

    CadastrarDisciplina.load = function (callback) {
        tabela = $('#listagem-Disciplina');

        $("#acoesFormulario").append(
                Componente.Botoes.Salvar("", "btn-salvar") +
                Componente.Botoes.Cancelar("", "btn-cancelar")
                );


        $("#btn-salvar").on('click', function () {
            validar(function () {
                salvar();
            });
        });

        $("#btn-cancelar").on('click', function () {
            cancelar();
        });

        callback();
    };

    function validar(callback) {
        var erros = new Array();

        if (Util.IsEmpty(nome.val())) {
            Util.InputColor.Vermelho(nome);
            erros.push("Nome da disciplina não pode estar vazio");
        }

        Componente.Validar(erros, function () {
            callback();
        });
    }

    function salvar() {
        Componente.Loading.Show();

        var objeto = new DisciplinaDto();
        if (isEdicao)
            objeto.id = $("#hiddenId").val();
        objeto.nome = $('#nome').val();

        var obj = JSON.stringify(objeto);

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "CadastrarDisciplina",
            type: 'POST',
            async: false,
            cache: false,
            processData: false,
            data: obj,
            dataType: 'json',
            success: function (data, textStatus, jqXHR) {
                Componente.Loading.Remove();
                Modais.Get.Basica(data.responseText, "abrirPaginaSemRefresh(window.location);").modal("show");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Componente.Loading.Remove();
                Modais.Get.Basica(jqXHR.responseText, "abrirPaginaSemRefresh(window.location);").modal("show");
            }
        });

    }

    function cancelar() {
        hiddenId.val("");
        nome.val("");
    }

    function TabelaEdicao(tabela, dados) {
        tabela.html("");
        return tabela.DataTable({
            "data": dados,
            "deferRender": true,
            "columns": [
                {
                    "title": "Nome da Disciplina",
                    "data": "nome",
                    "width": "80%",
                    "render": function (data) {
                        return data;
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
            var c = Componente.Icones.Excluir("javascript:CadastrarDisciplina.excluirDisciplina(" + row.id + ")", "");
            c += Componente.Icones.Editar("javascript:CadastrarDisciplina.editarDisciplina(" + row.id + ")", "");
            return c;
        }
        return Const.Messages.ERRO_1;
    }

    CadastrarDisciplina.carregarTabela = function () {
        nome.val("");
        hiddenId.val("");
        $.ajax({
            url: "PesquisarDisciplina",
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                tabelaDT = TabelaEdicao(tabela, data);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + erro.responseText).modal("show");
                Componente.Loading.Remove();
            }
        });
    };
    CadastrarDisciplina.editarDisciplina = function (id) {
        isEdicao = true;
        hiddenId.val(id);
        $.ajax({
            url: "BuscarDisciplina?id=" + id,
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                $("#nome").val(data.nome);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + erro.responseText);
                Componente.Loading.Remove();
            }
        });
    };

    CadastrarDisciplina.excluirDisciplina = function (id) {
        Modais.Get.Confirmacao("Deseja realmente excluir este item?", "CadastrarDisciplina.confirmaExcluir(" + id + ")", null).modal("show");
    };

    CadastrarDisciplina.confirmaExcluir = function (id) {
        
        $.ajax({
            url: "ExcluirDisciplina?id=" + id,
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                abrirPaginaSemRefresh(window.location);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                abrirPaginaSemRefresh(window.location);
                Componente.Loading.Remove();
            }
        });
    };

    return CadastrarDisciplina;
}());












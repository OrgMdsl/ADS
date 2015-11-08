/* global Util, Componente, AjaxHelper, CircularJSON, Modais, Const */

var isEdicao = false;
var hiddenId;
var nome;
var usuario;
var senha;
var file;
var tabelaDT;
var tabela;
var tabelaDisciplina;
var tabelaDisciplinaDT;
$(document).ready(function () {
    hiddenId = $("#hiddenId");
    nome = $("#nome");
    usuario = $("#usuario");
    senha = $("#senha");
    file = $("#file");
    isEdicao = Util.IsEmpty(hiddenId.val()) ? false : true;

    CadastrarProfessor.load(function () {

        CadastrarProfessor.carregarTabela(null);

        if (!isEdicao)
        {
            tabelaDisciplinaDT = $("#listagem-Disciplina").DataTable({
                "deferRender": true,
                "columns": [
                    {
                        "title": "Id",
                        "width": "40%"
                    },
                    {
                        "width": '40%',
                        "title": 'Nome'
                    },
                    {
                        "title": "Ações",
                        "width": "20%"
                    }
                ]
            });
            
            eventoExcluirItem($("#listagem-Disciplina"), tabelaDisciplinaDT);
        }

        

    });
});

function ProfessorDto() {
    ProfessorDto.id;
    ProfessorDto.nome;
    ProfessorDto.usuario;
    ProfessorDto.senha;
    ProfessorDto.file;
    ProfessorDto.disciplinas;
}

function DisciplinaDto() {
    DisciplinaDto.id;
    DisciplinaDto.nome;
    DisciplinaDto.professores;
}


var CadastrarProfessor = (function () {

    function CadastrarProfessor() {
    }

    CadastrarProfessor.load = function (callback) {
        tabela = $('#listagem-Professor');

        $("#acoesFormulario").append(
                Componente.Botoes.Salvar("", "btn-salvar") +
                Componente.Botoes.Cancelar("", "btn-cancelar")
                );

        $('#btn-add-item').on('click', function () {
            validaAddItem();
        });

        $("#btn-salvar").on('click', function () {
            validar(function () {
                salvar();
            });
        });

        $("#btn-cancelar").on('click', function () {
            cancelar();
        });

        $.ajax({
            url: "PesquisarDisciplina",
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                var html = "";
                var el = $("#disciplinas");
                html += "<option value=\"0\"></option>";
                for (var i = 0; i < data.length; i++) {
                    html += "<option value=\"" + data[i].id + "\">" + data[i].nome + "</option>";
                }
                el.append(html);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + jqXHR.responseText);
                Componente.Loading.Remove();
            }
        });


        callback();
    };

    function validar(callback) {
        var erros = new Array();

        if (Util.IsEmpty(nome.val())) {
            Util.InputColor.Vermelho(nome);
            erros.push("Nome do curso não pode estar vazio");
        }

        Componente.Validar(erros, function () {
            callback();
        });
    }

    function salvar() {
        Componente.Loading.Show();

        var ListaDisciplinaDto = new Array();
        var ListaProfessorDto = new Array();

        var objeto = new ProfessorDto();
        if (isEdicao)
            objeto.id = $("#hiddenId").val();
        objeto.nome = $('#nome').val();
        objeto.usuario = $("#usuario").val();
        objeto.senha = $("#senha").val();
        objeto.disciplinas = null; //Impedir referencia circular

        //Impede referencia circular
        var objetoAux = new ProfessorDto();
        objetoAux = jQuery.extend(true, {}, objeto);

        ListaProfessorDto.push(objetoAux);

        for (var i = 1; i <= tabelaDisciplinaDT.rows().data().length; i++) {
            var item = new DisciplinaDto();
            item.id = $("table tr:nth-child(" + i + ") td").eq(0).html();
            item.professores = ListaProfessorDto;
            ListaDisciplinaDto.push(item);
        }

        objeto.disciplinas = ListaDisciplinaDto;
        debugger;
        var obj = JSON.stringify(objeto);

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "CadastrarProfessor",
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
        tabelaDisciplinaDT.destroy();
    }

    function TabelaEdicao(tabela, dados) {
        tabela.html("");
        return tabela.DataTable({
            "data": dados,
            "deferRender": true,
            "columns": [
                {
                    "title": "Nome do Professor",
                    "data": "nome",
                    "width": "40%"
                },
                {
                    "title": "Usuário do Professor",
                    "data": "usuario",
                    "width": "40%"
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
            var c = Componente.Icones.Editar("javascript:CadastrarProfessor.editarProfessor(" + row.id + ")", "");
            c += Componente.Icones.Excluir("javascript:CadastrarProfessor.excluirProfessor(" + row.id + ")", "");
            return c;
        }
        return Const.Messages.ERRO_1;
    }

    CadastrarProfessor.montaAcoesDisciplinas = function (row) {
        if (!Util.IsNull(row)) {
            var c = Componente.Icones.Excluir("");

            return c;
        }
        return Const.Messages.ERRO_1;
    };

    function validaAddItem() {
        var validacoes = new Array();
        var disciplinas = $("#disciplinas");
        var select = $("#disciplinas option:selected");
        if (select.val() === '0') {
            Util.InputColor.Vermelho(disciplinas);
            validacoes.push("Selecione uma disciplina");
        }
        
        if (select.val() !== '0') {
            var idx = tabelaDisciplinaDT
                    .columns()
                    .data()
                    .eq(0) // Reduce the 2D array into a 1D array of data
                    .indexOf(select.val());

            if (idx !== -1) {
                Util.InputColor.Vermelho(select);
                validacoes.push("A disciplina ' " + select.text() + " ' já foi adicionada.");
            }
        }

        if (validacoes.length > 0) {
            var mensagem = "<span class='mensagem_modal_erro red'><b>Verifique os erros:</b><br/><br/>";
            for (var i = 0; i < validacoes.length; i++) {
                mensagem += "- " + validacoes[i] + "<br/>";
            }
            mensagem += "</span>";

            Modais.Get.Erro(mensagem, "").modal("show");
            return false;
        }

        tabelaDisciplinaDT.row.add([
            select.val(),
            select.text(),
            Componente.Icones.Excluir("")
        ]).draw(false);
    }

    CadastrarProfessor.carregarTabela = function () {
        nome.val("");
        hiddenId.val("");
        $.ajax({
            url: "PesquisarProfessor",
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                tabelaDT = TabelaEdicao(tabela, data);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + jqXHR.responseText).modal("show");
                Componente.Loading.Remove();
            }
        });

    };
    CadastrarProfessor.editarProfessor = function (id) {
        isEdicao = true;
        hiddenId.val(id);
        $.ajax({
            url: "BuscarProfessor?id=" + id,
            type: 'POST',
            success: function (data, textStatus, jqXHR) {
                $("#nome").val(data.nome);
                tabelaDisciplinaDT = TabelaEdicaoDisciplina($("#listagem-Disciplina"), data);
                eventoExcluirItem($("#listagem-Disciplina"), tabelaDisciplinaDT);
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Erro ao carregar as informações: <br><br>" + jqXHR.responseText);
                Componente.Loading.Remove();
            }
        });
    };

    CadastrarProfessor.excluirProfessor = function (id) {
        Modais.Get.Confirmacao("Deseja realmente excluir este item?", "CadastrarProfessor.confirmaExcluir(" + id + ")", null).modal("show");
    };

    CadastrarProfessor.confirmaExcluir = function (id) {

        $.ajax({
            url: "ExcluirProfessor?id=" + id,
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



    function TabelaEdicaoDisciplina(tabelaDisciplina, dados) {
        tabelaDisciplina.DataTable().destroy();
        tabelaDisciplinaDT = tabelaDisciplina.DataTable({
            "data": dados.disciplinas,
            "columns": [
                {
                    "title": "Id",
                    "data": "id",
                    "width": "40%"
                },
                {
                    "width": '40%',
                    "title": 'Nome',
                    "data": "nome"
                },
                {
                    "title": "Ações",
                    "width": "20%",
                    "render": function (data, type, row) {
                        return CadastrarProfessor.montaAcoesDisciplinas(row);
                    }
                }
            ]
        });
        return tabelaDisciplinaDT;
    }

    return CadastrarProfessor;
}());












var isEdicao = false;
$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenOperacao").val()) ? false : true;
    var tabela = $('#listagem-GenericoItem');
    var tabela_itens;
    if (!isEdicao) {
        tabela_itens = tabela.DataTable({
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
    }
    else {
        $.ajax({
            type: "POST",
            url: 'BuscaGenerico?id=' + $("id").val(),
            success: function (data) {
                tabela_itens = tabela.DataTable({
                    processing: false,
                    serverSide: false,
                    data: data.coreGenericoItems,
                    columns: [
                        {
                            width: '40%',
                            title: 'Descrição',
                            data: 'descricao'

                        },
                        {
                            width: '40%',
                            title: 'Sigla',
                            data: 'sigla'
                        },
                        {
                            width: '20%',
                            title: 'Ações',
                            render: function (data) {
                                var bts = Componente.Icones.Editar("");
                                if (data.ativo)
                                    bts += Componente.Icones.Desativar("");
                                else
                                    bts += Componente.Icones.Ativar("");
                            }
                        }
                    ]
                });
            },
            error: function (data) {

            }
        });
    }

    $('#btn-add-item').on('click', function () {

        if (Util.IsEmpty($("#itemSigla").val())) {
            alert("Não pode ficar em branco");
            return false;
        }
        if (Util.IsEmpty($("#itemDescricao").val())) {
            alert("Não pode ficar em branco");
            return false;
        }
        tabela_itens.row.add([
            $("#itemDescricao").val(),
            $("#itemSigla").val().toUpperCase(),
            Componente.Icones.Editar("", "") +
                    Componente.Icones.Ativar("", "") +
                    Componente.Icones.Excluir("", "")
        ]).draw(false);

        $("#itemSigla").val("");
        $("#itemDescricao").val("");
    });

    $("#acoesFormulario").append(
            Componente.Botoes.Salvar("", "btn-salvar") +
            Componente.Botoes.Cancelar("javascript:window.history.back()", "")
            );

    $("#btn-salvar").on('click', function () {
        var dataArray = new Array();
        for (var i = 1; i <= tabela_itens.rows().data().length; i++) {
            dataArray.push(
                    {
                        descricao: $("table tr:nth-child(" + i + ") td").eq(0).html(),
                        sigla: $("table tr:nth-child(" + i + ") td").eq(1).html(),
                        ativo: Util.HasClass($("table tr:nth-child(" + i + ") td").eq(2).children(".ico_muda_status")[0], "ativo")
                    }
            );
        }

        var formData =
                {
                    nome: $('#nome').val(),
                    descricao: $('#descricao').val(),
                    coreGenericoItems: dataArray
                };

        var obj = JSON.stringify(formData);

        $.ajax({
            type: "POST",
            url: "CadastrarGenerico",
            data: obj,
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                debugger;
            },
            error: function (data) {
                $("#page-wrapper").html(data);
            }
        });

    });

});


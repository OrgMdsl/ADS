var isEdicao = false;
var itens = new Array();
$(document).ready(function () {
    isEdicao = Util.IsEmpty($("#hiddenOperacao").val()) ? false : true;

    //Tela ListagemCoreGenerico
    $("#listagem-CoreGenerico").DataTable({
        processing: false,
        serverSide: false,
        ajax: {
            url: 'ListaCoreGenerico',
            pages: 5,
            dataSrc: ""
        },
        columns: [
            {
                width: '10%',
                title: 'Id',
                data: 'idGenerico'
            },
            {
                width: '40%',
                title: 'Nome',
                data: 'nome'
            },
            {
                width: '40%',
                title: 'Descrição',
                data: 'descricao'
            },
            {
                width: '10%',
                title: 'Ações',
                render: function (data, type, full) {
                    return Componente.Icones.Visualizar("")
                            + Componente.Icones.Editar("")
                            + Componente.Icones.Excluir("")
                            + Componente.Icones.Ativar("")
                            + Componente.Icones.Desativar("");

                }
            }
        ]
    });

    //Tela CadastroCoreGenerico

    var tabela_itens;
    if (!isEdicao) {
        tabela_itens = $('#listagem-CoreGenericoItem').DataTable({
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
        tabela_itens = $('#listagem-CoreGenericoItem').DataTable({
            processing: false,
            serverSide: false,
            ajax: {
                url: 'BuscaCoreGenerico?id=' + $("id").val(),
                pages: 5,
                dataSrc: "coreGenericoItems"
            },
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
                        return Componente.Icones.Editar("PaginaEditarCoreGenerico?id=" + data.id + "&op=E")
                                + Componente.Icones.Excluir("");
                    }
                }
            ]
        });
    }

    //Tela CadastroCoreGenerico
    $('#btn-add-item').on('click', function () {
        tabela_itens.row.add([
            $("#itemDescricao").val(),
            $("#itemSigla").val(),
            Componente.Icones.Editar("") + Componente.Icones.Excluir("")
        ]).draw(false);
    });

    $("#page-wrapper").append(Componente.Botoes.Salvar("salvar();"));

});

function dataRow(value1, value2) {
    this.descricao = value1;
    this.sigla = value2;
}


function salvar()
{
    var table = $('#listagem-CoreGenericoItem').DataTable();
    var dataArray = new Array();
    for (var i = 1; i <= table.rows().data().length; i++) {
        dataArray.push(
                new dataRow(
                        $("table tr:nth-child(" + i + ") td").eq(0).html(),
                        $("table tr:nth-child(" + i + ") td").eq(1).html())
                );
    }

    var sJson = JSON.stringify(dataArray);

    alert(sJson);
    /*
     $.ajax({
     type: "POST",
     url : "tableData.htm?jsonData="+jsonString,
     success: function(data){
     $("#").html(data);      
     },
     error:function(data){
     console.log("failure"+data);
     alert("failure"+data);
     }
     });  */
}
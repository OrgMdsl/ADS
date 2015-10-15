$(document).ready(function () {
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
                    var botoes = Componente.Icones.Visualizar("");
                    botoes += Componente.Icones.Editar("");
                    botoes += Componente.Icones.Excluir("");
                    botoes += Componente.Icones.Ativar("");
                    botoes += Componente.Icones.Desativar("");
                    return botoes;
                }                
            }
        ]
    });
    
    var t = $('#listagem-CoreGenericoItem').DataTable();
    var counter = 1;
 
    $('#addRow').on( 'click', function () {
        t.row.add( [
            counter +'.1',
            counter +'.2',
            counter +'.3',
            counter +'.4',
            counter +'.5'
        ] ).draw( true );
 
        counter++;
    } );
});

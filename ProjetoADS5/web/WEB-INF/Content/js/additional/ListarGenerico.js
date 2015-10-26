$(document).ready(function () {

    $('#listagem').DataTable({
        "ajax": {
            "url": "ListarGenerico",
            "pages": 5,
            "dataSrc": ""
        },
        "deferRender": true,
        "columns": [
            {
                "title": "Id",
                "data": "id",
                "width": "10%"
            },
            {
                "title": "Nome",
                "data": "nome",
                "width": "30%"
            },
            {
                "title": "Descrição",
                "data": "descricao",
                "width": "40%"
            },
            {
                "title": "Ações",
                "width": "20%",
                "render": function (data, type, row) {
                    if (!Util.IsNull(row)) {
                        var c = Componente.Icones.Visualizar("PaginaVisualizarGenerico?id=" + row.id)
                                + Componente.Icones.Editar("PaginaEditarGenerico?id=" + row.id);
                        if (row.ativo === false)
                            c += Componente.Icones.Ativar("","AlterarStatusGenerico?id=" + row.id);
                        else
                            c += Componente.Icones.Desativar("","AlterarStatusGenerico?id=" + row.id);
                        return c;
                    }
                    return Const.Messages.ERRO_1;
                }
            }
        ]
    });
    
    $('#listagem')
    .on( 'processing.dt', function ( e, settings, processing ) {
        $('#processingIndicator').css( 'display', processing ? 'block' : 'none' );
    } )
    .dataTable();
});
$(document).ready(function () {
        
    Ajax.Post("ModalAtencao", false, "corpo=Teste de corpo",
            function (data) {
                modal(data);
            },
            function (data) {
                alert(data.responseText);
            }
    );
    
    $('#myTable').DataTable( {
    ajax: "Exemplo",
    columns: [
        { data: 'name' },
        { data: 'hr.position' },
        { data: 'hr.salary' },
        { data: 'hr.state_date' },
        { data: 'contact.office' },
        { data: 'contact.extn' }
    ]
} );
    
});

$(document).ready(function () {
        
    Ajax.Post("ModalAtencao", false, "corpo=Teste de corpo",
            function (data) {
                modal(data);
            },
            function (data) {
                alert(data.responseText);
            }
    );
    
});

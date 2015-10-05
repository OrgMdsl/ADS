$(document).ready(function () {

    ajax("ModalAtencao?corpo='Teste de corpo'",
            function(data) { modal(data); },
            function(data) { alert(data.responseText); }
        );

});

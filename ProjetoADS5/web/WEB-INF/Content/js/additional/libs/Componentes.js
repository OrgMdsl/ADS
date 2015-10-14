var Componente = (function () {
    var Botoes;
    
    function Componente() {
    }
    
    Componente.Botoes = {
        Editar: function (url_link) {
            return montaBotao(url_link, "componente_btn orange", "fa-pencil", "Editar");
        },
        Visualizar: function (url_link) {
            return montaBotao(url_link, "componente_btn", "fa-search", "Visualizar");
        },
        Excluir: function (url_link) {
            return montaBotao(url_link, "componente_btn red", "fa-trash", "Excluir");
        },
        Novo: function (url_link) {
            return montaBotao(url_link, "componente_btn", "fa-plus", "Novo");
        },
        Recuperar: function (url_link) {
            return montaBotao(url_link, "componente_btn gray", "fa-undo", "Recuperar");
        },
        Ativar: function (url_link) {
            return montaBotao(url_link,"componente_btn gray", "fa-toggle-off", "Inativo");
        },
        Desativar: function (url_link) {
            return montaBotao(url_link,"componente_btn green", "fa-toggle-on", "Ativo");
        }
    };
    
    function montaBotao(url, clazz, icon, title) {
        return "<span class='" + clazz + "'><a href='" + url + "'><i class='fa " + icon + "' title='" + title + "'></i></a></span>";
    }

    return Componente;
}());
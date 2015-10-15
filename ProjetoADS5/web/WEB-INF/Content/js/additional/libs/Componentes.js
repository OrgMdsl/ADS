var Componente = (function () {
    var Botoes;

    function Componente() {
    }

    Componente.Icones = {
        Editar: function (url_link) {
            return montaIcone(url_link, "componente_ico orange", "fa-pencil", "Editar");
        },
        Visualizar: function (url_link) {
            return montaIcone(url_link, "componente_ico", "fa-search", "Visualizar");
        },
        Excluir: function (url_link) {
            return montaIcone(url_link, "componente_ico red", "fa-trash", "Excluir");
        },
        Novo: function (url_link) {
            return montaIcone(url_link, "componente_ico", "fa-plus", "Novo");
        },
        Recuperar: function (url_link) {
            return montaIcone(url_link, "componente_ico gray", "fa-undo", "Recuperar");
        },
        Ativar: function (url_link) {
            return montaIcone(url_link, "componente_ico inativo ico_muda_status", "fa-toggle-off", "Inativo");
        },
        Desativar: function (url_link) {
            return montaIcone(url_link, "componente_ico ativo ico_muda_status", "fa-toggle-on", "Ativo");
        }
    };

    Componente.Botoes = {
        Editar: function (onclick) {
            return montaBotao("Editar",onclick,"","btn-custom btn-custom-primary");
        },
        Visualizar: function (onclick) {
            return montaBotao("Visualizar",onclick,"","btn-custom btn-custom-primary");
        },
        Excluir: function (onclick) {
            return montaBotao("Excluir",onclick,"","btn-custom btn-custom-primary");
        },
        Novo: function (onclick) {
            return montaBotao("Novo",onclick,"","btn-custom btn-custom-primary");
        },
        Cancelar: function (onclick) {
            return montaBotao("Cancelar",onclick,"","btn-custom btn-custom-default");
        },
        Salvar: function (onclick) {
            return montaBotao("Salvar",onclick,"","btn-custom btn-custom-primary");
        },
        Voltar: function (onclick) {
            return montaBotao("Voltar",onclick,"","btn-custom btn-custom-default");
        },
        Ok: function (onclick) {
            return montaBotao("Ok",onclick,"","btn-custom btn-custom-default");
        },
    };


    function montaIcone(url, clazz, icon, title) {
        return "<span class='" + clazz + "'><a href='" + url + "' ><i class='fa " + icon + "' title='" + title + "'></i></a></span>";
    }

    function montaBotao(txt, onclick, clazz_span, clazz_button) {
        return "<span class='" + clazz_span + "'><button type='button' class='btn " + clazz_button + "' onclick=\"" + onclick + "\">" + txt + "</button></span>";
    }

    return Componente;
}());
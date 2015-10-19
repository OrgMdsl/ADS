var Componente = (function () {
    var Botoes;

    function Componente() {
    }

    Componente.Icones = {
        Editar: function (url_link, id) {
            return montaIcone(url_link, "componente_ico orange editar", "fa-pencil", "Editar", id);
        },
        Visualizar: function (url_link, id) {
            return montaIcone(url_link, "componente_ico visualizar", "fa-search", "Visualizar", id);
        },
        Excluir: function (url_link, id) {
            return montaIcone(url_link, "componente_ico red excluir", "fa-trash", "Excluir", id);
        },
        Novo: function (url_link, id) {
            return montaIcone(url_link, "componente_ico novo", "fa-plus", "Novo", id);
        },
        Recuperar: function (url_link, id) {
            return montaIcone(url_link, "componente_ico gray recuperar", "fa-undo", "Recuperar", id);
        },
        Ativar: function (id) {
            return montaIconeStatus("componente_ico inativo ico_muda_status ativar", "fa-toggle-off", "Inativo", id);
        },
        Desativar: function (id) {
            return montaIconeStatus("componente_ico ativo ico_muda_status desativar", "fa-toggle-on", "Ativo", id);
        }
    };

    Componente.Botoes = {
        Editar: function (onclick, id) {
            return montaBotao("Editar", onclick, "", "btn-custom btn-custom-primary", id);
        },
        Visualizar: function (onclick, id) {
            return montaBotao("Visualizar", onclick, "", "btn-custom btn-custom-primary", id);
        },
        Excluir: function (onclick, id) {
            return montaBotao("Excluir", onclick, "", "btn-custom btn-custom-primary", id);
        },
        Novo: function (onclick, id) {
            return montaBotao("Novo", onclick, "", "btn-custom btn-custom-primary", id);
        },
        Cancelar: function (onclick, id) {
            return montaBotao("Cancelar", onclick, "", "btn-custom btn-custom-default", id);
        },
        Salvar: function (onclick, id) {
            return montaBotao("Salvar", onclick, "", "btn-custom btn-custom-primary", id);
        },
        Voltar: function (onclick, id) {
            return montaBotao("Voltar", onclick, "", "btn-custom btn-custom-default", id);
        },
        Ok: function (onclick, id) {
            return montaBotao("Ok", onclick, "", "btn-custom btn-custom-default", id);
        }
    };

    Componente.fnBtnToggleStatus = function(_el) {
        var el = $(_el);
        if(Util.HasClass(_el, "ativo"))
            $(el).replaceWith(Componente.Icones.Ativar("", ""));
        else
            $(el).replaceWith(Componente.Icones.Desativar("", ""));
    };

    function montaIcone(url, clazz, icon, title, id) {
        if(Util.IsEmpty(url))
            return "<span class='" + clazz + "' title='" + title + "'><i class='fa " + icon + "' id='" + id + "'></i></span>";
        else
            return "<span class='" + clazz + "' title='" + title + "'><a href='" + url + "' ><i class='fa " + icon + "' id='" + id + "'></i></a></span>";
    }
    
    function montaIconeStatus(clazz, icon, title, id) {
            return "<span class='" + clazz + "' title='" + title + "' onclick='Componente.fnBtnToggleStatus(this);'><i class='fa " + icon + "' id='" + id + "'></i></span>";
        
    }

    function montaBotao(txt, onclick, clazz_span, clazz_button, id) {
        return "<span class='" + clazz_span + "'><button type='button' id='" + id + "' class='btn " + clazz_button + "' onclick=\"" + onclick + "\">" + txt + "</button></span>";
    }

    return Componente;
}());
/* global Componente, Util, Const */
var Componente = (function () {
    var Botoes;

    function Componente() {
    }

    Componente.Loading = {
        Show: function () {
            $("html").append("<div class='loading'><div>Por favor, aguarde ...</div></div>");
            $(".loading div").fadeIn(300);
        },
        Remove: function () {
            $(".loading").fadeOut(150, function() { $(this).remove(); });
        }
    };

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
        Ativar: function (id, action) {
            return icone_status.ativar(id, action);
        },
        Desativar: function (id, action) {
            return icone_status.desativar(id, action);
        }
    };

    var icone_status = {
        ativar: function (id, action) {
            return montaIconeStatus("componente_ico inativo ico_muda_status ativar", "fa-toggle-off", "Inativo", false, id, action);
        },
        desativar: function (id, action) {
            return montaIconeStatus("componente_ico ativo ico_muda_status desativar", "fa-toggle-on", "Ativo", true, id, action);
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

    Componente.Input = {
        Checkbox: function (onclick, ativo, id) {
            return "<input type='checkbox' id='" + id + "' onclick='" + onclick + "' " + (ativo ? 'checked' : '') + "/>";
        }
    };

    Componente.fnBtnToggleStatus = function (_el, id, action) {
        Componente.Loading.Show();
        var el = $(_el);
        var ico;
        if (Util.HasClass(_el, "ativo"))
            ico = icone_status.ativar(id, action);
        else
            ico = icone_status.desativar(id, action);

        if (!Util.IsEmpty(action))
            $.ajax({
                url: action,
                success: function (data, textStatus, jqXHR) {
                    $(el).replaceWith(ico);
                    Componente.Loading.Remove();
                },
                error: function (jqXHR, textStatus, errorThrown) {
                }
            });
        else {
            $(el).replaceWith(ico);
            Componente.Loading.Remove();
        }
    };

    function montaIcone(url, clazz, icon, title, id) {
        if (Util.IsEmpty(url))
            return "<span class='" + clazz + "' title='" + title + "'><i class='fa " + icon + "' id='" + id + "'></i></span>";
        else
            return "<span class='" + clazz + "' title='" + title + "'><a href='" + url + "' ><i class='fa " + icon + "' id='" + id + "'></i></a></span>";
    }

    function montaIconeStatus(clazz, icon, title, ativo, id, action) {
        return "<span class='" + clazz + "' title='" + title + "' onclick=\"Componente.fnBtnToggleStatus(this,'" + id + "','" + action + "');\"><i class='fa " + icon + "' id='" + id + "'></i>"
                + Componente.Input.Checkbox("", ativo, Const.Class.Pre.MUDA_STATUS + id) + "</span>";

    }

    function montaBotao(txt, onclick, clazz_span, clazz_button, id) {
        return "<span class='" + clazz_span + "'><button type='button' id='" + id + "' class='btn " + clazz_button + "' onclick=\"" + onclick + "\">" + txt + "</button></span>";
    }

    return Componente;
}());
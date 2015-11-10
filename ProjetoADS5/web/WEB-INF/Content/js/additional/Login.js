/* global Util, Componente, AjaxHelper, Modais */

var inputs = {};

$(document).ready(function () {
    inputs = {
        usuario: $('#usuario'),
        senha: $('#senha')
    };
    Login.load();

});

function LoginDto() {
    LoginDto.usuario;
    LoginDto.senha;
    LoginDto.nome;
    LoginDto.administrador;
}

function PerfilDto() {
    PerfilDto.descricao;
    PerfilDto.sigla;
    PerfilDto.ativo;
}

var Login = (function () {

    function Login() {
    }

    Login.load = function () {

        $("#acoesFormulario").append(
                Componente.Botoes.Entrar("", "btn-entrar") +
                Componente.Botoes.Cancelar("javascript:window.history.back()", "")
                );

        $('#btn-entrar').on('click', function () {
            entrar();
        });
    };

    function entrar() {
        var validacoes = new Array();
        Componente.Loading.Show();

        if (Util.IsEmpty(inputs.usuario.val())) {
            Util.InputColor.Vermelho(inputs.usuario);
            validacoes.push("Digite seu nome de usuário");
        }
        if (Util.IsEmpty(inputs.senha.val())) {
            Util.InputColor.Vermelho(inputs.senha);
            validacoes.push("Digite sua senha");
        }

        if (validacoes.length > 0) {
            var mensagem = "<span class='mensagem_modal_erro red'><b>Preencha os campos corretamente:</b><br/><br/>";
            for (var i = 0; i < validacoes.length; i++) {
                mensagem += "- " + validacoes[i] + "<br/>";
            }
            mensagem += "</span>";
            Componente.Loading.Remove();
            Modais.Get.Erro(mensagem, function (obj) {
                fecharModal(obj.idModal);
            }).modal("show");
            return false;
        }

        var objeto = new LoginDto();
        objeto.usuario = inputs.usuario.val();
        objeto.senha = inputs.senha.val();

        if ($("#ckLembraInfo").is(":checked"))
            objeto.chk = true;

        var obj = JSON.stringify(objeto);

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "FazerLogin",
            type: 'POST',
            data: obj,
            dataType: "json",
            success: function (data, textStatus, jqXHR) {

                if (Util.IsNull(data))
                {
                    Modais.Get.Erro("Usuário e/ou senha incorretos").modal("show");
                }
                else
                {
                    if (window.location.href.indexOf("PaginaLogin") > -1)
                        abrirPagina('home');
                    else
                        abrirPaginaSemRefresh(window.location);
                }
                Componente.Loading.Remove();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                Modais.Get.Erro("Verifique seus dados.").modal("show");
                Componente.Loading.Remove();
            }
        });
    }

    return Login;
}());


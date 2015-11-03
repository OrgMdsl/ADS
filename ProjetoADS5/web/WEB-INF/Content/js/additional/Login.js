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
    LoginDto.perfil;
    LoginDto.ativo;
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
                
        objeto.ativo = $("#ckLembraInfo").is(":checked"); //Neste caso é usado para levar a informação do CheckBox
        var obj = JSON.stringify(objeto);

        Componente.Loading.Remove();
       
        
        AjaxHelper.Post("FazerLogin", false, null, obj,
                function (sucesso) {
                    
                    if(Util.IsNull(sucesso))
                    {
                        Modais.Get.Erro("Usuário e/ou senha incorretos").modal("show");
                        return false;
                    }
                    
                    Modais.Get.Basica("Seja bem-vindo").modal("show");
                },
                function (erro) {
                    Modais.Get.Erro(erro.responseText).modal("show");
                    return false;
                });
    }

    return Login;
}());


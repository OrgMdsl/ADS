/* global Util, Componente, AjaxHelper */

var inputs = {
    usuario : $('#usuario'),
    senha : $('#senha')
};

$(document).ready(function () {

    Login.load();

});

function LoginDto(usuario, senha, perfil, ativo) {
    this.usuario = usuario;
    this.senha = senha;
    this.perfil = perfil;
    this.ativo = ativo;
}

function PerfilDto(descricao, sigla, ativo) {
    this.descricao = descricao;
    this.sigla = sigla;
    this.ativo = ativo;
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
        
        Componente.Loading.Show();
        
        if (Util.IsEmpty(inputs.usuario.val())) {
            alert("Não pode ficar em branco");
            return false;
        }
        if (Util.IsEmpty(inputs.senha.val())) {
            alert("Não pode ficar em branco");
            return false;
        }

        var objeto = new LoginDto(
                inputs.usuario.val(),
                inputs.senha.val()
                );

        var obj = JSON.stringify(objeto);

        Componente.Loading.Remove();

        AjaxHelper.Post("FazerLogin", true, null, obj,
                function (sucesso) {
                    modal("Atenção", sucesso.responseText);
                },
                function (erro) {
                    modal("Atenção", erro.responseText);
                });
    }

    return CadastrarGenerico;
}());


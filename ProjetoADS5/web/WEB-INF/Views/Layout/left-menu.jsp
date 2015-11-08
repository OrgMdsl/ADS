<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar_left">
    <ul class="nav navbar-nav side-nav">
        <li class="active">
            <a href="javascript:abrirPagina('home');"><i class="fa fa-fw fa-home"></i> Home</a>
        </li>
        <li>
            <a href="javascript:abrirPagina('PaginaDisciplina' + Const.AccessControl.RESTRITO);">Disciplina</a>
        </li>
        <li>
            <a href="javascript:abrirPagina('PaginaCurso' + Const.AccessControl.RESTRITO);">Curso</a>
        </li>
        <li>
            <a href="javascript:abrirPagina('PaginaProfessor' + Const.AccessControl.RESTRITO);">Professor</a>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#menu_itensGenericos">Conteúdos <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="menu_itensGenericos" class="collapse">
                <li>
                    <a href="javascript:abrirPagina('PaginaListarGenerico' + Const.AccessControl.RESTRITO);">Tópicos</a>
                </li>
                <li>
                    <a href="javascript:abrirPagina('PaginaCadastrarGenerico' + Const.AccessControl.RESTRITO);">Cadastrar</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#menu_usuario"> Usuário <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="menu_usuario" class="collapse">
                <li>
                    <a href="javascript:abrirPagina('PaginaLogin');">Login</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
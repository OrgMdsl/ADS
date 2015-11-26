<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
    </head>
    <body>

        <div class="row" style="min-height:400px">
            <c:if test="${usuarioLogado != null}">
                <c:if test="${usuarioLogado.administrador}">
                    <div onclick="abrirPagina('PaginaDisciplina' + Const.AccessControl.RESTRITO);" title="Disciplinas" style="background: #3e8f3e;" class="botoes_inicio">
                        <i class="fa fa-book fa-inverse"></i>
                        <div>Disciplinas</div>
                    </div>
                    <div onclick="abrirPagina('PaginaCurso' + Const.AccessControl.RESTRITO);" title="Cursos" style="background: #ee4545;" class="botoes_inicio">
                        <i class="fa fa-cubes fa-inverse"></i>
                        <div>Cursos</div>
                    </div>
                    <div onclick="abrirPagina('PaginaProfessor' + Const.AccessControl.RESTRITO);" title="Professores" style="background: #222;" class="botoes_inicio">
                        <i class="fa fa-graduation-cap fa-inverse"></i>
                        <div>Professores</div>
                    </div>
                </c:if>
            </c:if>

            <c:if test="${usuarioLogado == null}">
                <div style="height:400px"></div>
            </c:if>

            <c:if test="${usuarioLogado != null && !usuarioLogado.administrador}">
                <div onclick="abrirPagina('PaginaListarGenerico' + Const.AccessControl.RESTRITO);" title="Conteúdos" style="background: #fb7d2c;" class="botoes_inicio">
                    <i class="fa fa-tags fa-inverse"></i>
                    <div>Tópicos e Conteúdos</div>
                </div>
            </c:if>
        </div>    

    </body>

</html>

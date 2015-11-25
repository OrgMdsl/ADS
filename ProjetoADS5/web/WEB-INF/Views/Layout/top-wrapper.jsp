<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Navigation -->
<nav id="navbar_topo" class="navbar navbar-inverse navbar-fixed-top custom-navbar" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#sidebar_left">
            <span class="sr-only">Menu</span>
            <i class="fa fa-bars"></i>
        </button>

        <a class="navbar-brand" href="home"><strong>Gerenciador de Conteúdos</strong> - <small> LZ Systems </small></a>

    </div>
    <!-- Top Menu Items -->
    <ul class="nav navbar-right top-nav">

        <c:choose>
            <c:when test="${usuarioLogado != null}">
                <li class="dropdown">                    
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> ${usuarioLogado.nome} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="javascript:logout()"><i class="fa fa-fw fa-power-off"></i> Sair</a>
                        </li>
                    </ul>
                </li>
            </c:when>
            <c:otherwise>
                <li class="dropdown">
                    <a href="javascript:abrirPagina('PaginaLogin')">Entrar</a>
                </li>
            </c:otherwise>
        </c:choose>

    </ul>
    <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
    <c:import url="/WEB-INF/Views/Layout/left-menu.jsp" />
    <!-- /.navbar-collapse -->
</nav>
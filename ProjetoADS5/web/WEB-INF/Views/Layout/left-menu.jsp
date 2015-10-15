<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="collapse navbar-collapse navbar-ex1-collapse" id="sidebar_left">
    <ul class="nav navbar-nav side-nav">
        <li class="active">
            <a href="index"><i class="fa fa-fw fa-home"></i> Home</a>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#itensGenericos"><i class="fa fa-fw fa-arrows-v"></i> Itens Genéricos <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="itensGenericos" class="collapse">
                <li>
                    <a href="PaginaListagemCoreGenerico">Listagem</a>
                </li>
                <li>
                    <a href="PaginaCadastroCoreGenerico">Cadastrar</a>
                </li>
            </ul>
        </li>
    </ul>
</div>
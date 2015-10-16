<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
        <script src="additional/CoreGenerico.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel-body">
                    <div class="form-group">
                        <form class="form-horizontal" action="CadastrarCoreGenerico">
                            <input type="hidden" value="${ObjId}" name="id"/>
                            <div class="form-group">
                                <label for="nome" class="control-label col-xs-2">Nome</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome do campo" maxlength="50">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="descricao" class="control-label col-xs-2">Descrição</label>
                                <div class="col-xs-10">
                                    <input type="text" class="form-control" id="descricao" placeholder="Sigla" name="descricao" maxlength="50">
                                </div>
                            </div>
                            <table id="listagem-CoreGenericoItem" class="table table-condensed table-hover table-responsive table-striped"> 
                                <thead>
                                    <tr>
                                        <th>Descrição</th>
                                        <th>Sigla</th>
                                        <th>Ações</th>
                                    </tr>
                                </thead>
                            </table>
                            <input type="button" class="btn btn-custom btn-custom-default" value="Adicionar" id="btn-add-item" />
                           <!-- <div class="form-group">
                                <div class="col-xs-offset-2 col-xs-10">
                                    <div class="checkbox">
                                        <label><input type="checkbox"> Remember me</label>
                                    </div>
                                </div>
                            </div> -->
                            <div class="form-group">
                                <div class="col-xs-offset-2 col-xs-10">
                                    <button type="submit" class="btn btn-primary">Salvar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div> 
        </div>

    </body>

</html>
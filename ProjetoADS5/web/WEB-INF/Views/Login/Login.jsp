<%-- 
    Document   : login
    Created on : 29/10/2015, 18:36:16
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel-body">
                    <div class="form-group">
                        <form class="form-horizontal" action="" id="form-Login">
                            <div class="panel panel-default">
                                <div class="panel-heading">${PanelName}</div>
                                <div class="panel-body">
                                    <div class="form-group form-inline">
                                        <label for="nome" class="control-label col-xs-1">Usuário:</label>
                                        <input type="text" class="form-control col-xs-3" id="usuario" name="usuario" placeholder="meuusuario" maxlength="50">
                                        <label for="descricao" class="control-label col-xs-1">Senha:</label>
                                        <input type="password" class="form-control col-xs-5" id="senha" name="senha" placeholder="senha"  maxlength="50">
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-offset-10" id="acoesFormulario">

                                        </div>
                                    </div>
                                    </form>
                                </div>
                            </div>
                    </div>
                </div>
            </div> 
        </div>


    </body>
</html>

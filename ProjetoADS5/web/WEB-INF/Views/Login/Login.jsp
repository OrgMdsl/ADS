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
        <script src="js/additional/Login.js" type="text/javascript"></script>
        <title>Entrar</title>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-8">
                <div class="panel-body">
                    <div class="form-group">
                        <form class="form-horizontal" action="" id="form-Login">
                            <div class="panel panel-default">
                                <div class="panel-heading">${PanelName}</div>
                                <div class="panel-body">
                                    <div class="form-group form-inline">
                                        <label for="usuario" class="control-label col-lg-2">Usuário:</label>
                                        <input type="text" class="form-control col-lg-3" id="usuario" name="usuario" value="${usuarioCookie}" placeholder="usuario" maxlength="50">
                                        <label for="senha" class="control-label col-lg-2">Senha:</label>
                                        <input type="password" class="form-control col-lg-3" id="senha" name="senha" value="${senhaCookie}" placeholder="senha"  maxlength="50">
                                    </div>
                                    <div class="form-group form-inline">                                        
                                        <input type="checkbox" class="col-lg-2" id="ckLembraInfo" name="ckLembraInfo">
                                        <label for="ckLembraInfo" class="control-label col-lg-offset-0"> Lembrar das minhas informações.</label>
                                    </div>

                                    </form>
                                </div>
                                <div class="panel-footer">
                                    <div class="col-lg-offset-8" id="acoesFormulario">

                                    </div>
                                </div>
                            </div>
                    </div>
                </div>
            </div> 
        </div>


    </body>
</html>

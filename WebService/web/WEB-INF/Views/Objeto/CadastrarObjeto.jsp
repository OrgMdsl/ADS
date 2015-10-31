<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
        <script src="additional/CadastrarObjeto.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel-body">
                    <div class="form-group">
                        <form class="form-horizontal" action="" id="form-Generico">
                            <input type="hidden" value="${ObjId}" name="id" id="hiddenId"/>
                            <div class="panel panel-default">
                                <div class="panel-heading">Lista Objeto</div>
                                <div class="panel-body">
                                    <div class="form-group form-inline">

                                        <label for="descricao" class="control-label col-xs-1">Descrição</label>
                                        <input type="text" class="form-control col-xs-5" id="descricao" name="descricao" placeholder="Descrição"  maxlength="50">
                                    </div>

                                    <div class="panel panel-default">
                                        <div class="panel-heading">Atributos</div>
                                        <div class="panel-body">
                                            <div class="form-inline form-group">
                                                <label for="descricaoAtributo" class="control-label col-xs-1">Descrição: </label>
                                                <input type="text" class="form-control col-xs-1" id="descricaoAtributo" name="descricaoAtributo" placeholder="Atributo"  maxlength="50">

                                                <div class="panel panel-default">
                                                    <div class="panel-heading">Opções</div>
                                                    <div class="panel-body">
                                                        <div class="form-inline form-group">
                                                            <label for="opcaoAtributo" class="control-label col-xs-1">Opção: </label>
                                                            <input type="text" class="form-control col-xs-1" id="opcaoAtributo" name="opcaoAtributo" placeholder="Opção"  maxlength="50">
                                                            <input type="button" class="btn btn-custom btn-custom-default col-xs-1" name="" value="Adicionar" id="btn-add-opcao" />
                                                        </div>
                                                        <br>
                                                        <div>
                                                            <table id="listagem-ObjetoItem" class="table table-condensed table-hover table-responsive table-striped"> 

                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>



                                                <input type="button" class="btn btn-custom btn-custom-default col-xs-1" name="objetoAtributo" value="Adicionar" id="btn-add-atributo" />
                                            </div>
                                            <br>
                                            <div>
                                                <table id="listagem-ObjetoItem" class="table table-condensed table-hover table-responsive table-striped"> 

                                                </table>
                                            </div>
                                        </div>
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
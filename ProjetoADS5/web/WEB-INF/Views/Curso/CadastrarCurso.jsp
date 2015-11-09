<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
        <script src="additional/CadastrarCurso.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel-body">
                    <div class="form-group">
                        <form class="form-horizontal" action="" id="form-Generico">
                            <input type="hidden" value="${ObjId}" name="id" id="hiddenId"/>
                            
                            <div class="panel panel-default">
                                <div class="panel-heading" id="panelListaHead" style="cursor: pointer;">Cursos</div>
                                <div class="panel-body" id="panelLista">
                                    <div>
                                        <table id="listagem-Curso" class="table table-condensed table-hover table-responsive table-striped"> 
                                        </table>
                                    </div>
                                    <input type="button" class="btn btn-custom btn-custom-primary col-lg-1" name="novo" value="Novo" id="btn-novo" />
                                </div>
                            </div>
                            
                            <div class="panel panel-default">
                                <div class="panel-heading" id="panelCadastroHead" style="cursor:pointer;">Curso</div>
                                <div class="panel-body" id="panelCadastro">                                    
                                    <div class="form-group form-inline">
                                        <div class="row">
                                            <div class="form-inline">
                                                <div id="foto" class="foto-container col-xs-offset-2">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-inline">

                                                <label for="nome" class="control-label col-lg-2">Nome:</label>
                                                <input type="text" class="form-control col-lg-4" id="nome" name="nome" placeholder="Nome">

                                            </div>
                                        </div>                                      
                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Disciplinas</div>
                                        <div class="panel-body">
                                            <div class="row">
                                                <div class="form-inline">
                                                    <label for="disciplinas" class="control-label col-lg-3">Adicionar Disciplinas:</label>
                                                    <select class="form-control col-lg-4" id="disciplinas"></select>
                                                    <input type="button" class="btn btn-custom btn-custom-default col-lg-1" name="itemDisciplina" value="Adicionar" id="btn-add-item" />
                                                </div>
                                            </div>
                                            <div>
                                                <table id="listagem-Disciplina" class="table table-condensed table-hover table-responsive table-striped"> 
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-offset-5" id="acoesFormulario">

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
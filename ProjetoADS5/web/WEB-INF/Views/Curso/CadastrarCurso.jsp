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
                                <div class="panel-heading">Curso</div>
                                <div class="panel-body">
                                    <div class="form-group form-inline">
                                        <label for="nome" class="control-label col-xs-1">Nome:</label>
                                        <input type="text" class="form-control col-xs-3" id="nome" name="nome" placeholder="Curso">
                                        <select class="form-control col-xs-3" id="disciplinas"></select>
                                        <input type="button" class="btn btn-custom btn-custom-default col-xs-1" name="itemDisciplina" value="Adicionar" id="btn-add-item" />


                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Disciplinas</div>
                                        <div class="panel-body">
                                            <div>
                                                <table id="listagem-Disciplina" class="table table-condensed table-hover table-responsive table-striped"> 
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-offset-5" id="acoesFormulario">

                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading">Cursos</div>
                                        <div class="panel-body">
                                            <div>
                                                <table id="listagem-Curso" class="table table-condensed table-hover table-responsive table-striped"> 
                                                </table>
                                            </div>
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
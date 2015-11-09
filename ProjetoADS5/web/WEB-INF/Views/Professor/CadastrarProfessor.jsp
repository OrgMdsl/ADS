<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
        <script src="additional/CadastrarProfessor.js" type="text/javascript"></script>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel-body">
                    <div class="form-group">
                        <form class="form-horizontal" action="" id="form-Generico">
                            <input type="hidden" value="${ObjId}" name="id" id="hiddenId"/>

                            <div class="panel panel-default">
                                <div class="panel-heading" id="panelListaHead" style="cursor:pointer;">Professores</div>
                                <div class="panel-body" id="panelLista">
                                    <div>
                                        <table id="listagem-Professor" class="table table-condensed table-hover table-responsive table-striped"> 
                                        </table>
                                    </div>
                                    <input type="button" class="btn btn-custom btn-custom-primary col-lg-1" name="novo" value="Novo" id="btn-novo" />
                                </div>                                
                            </div>


                            <div class="panel panel-default">
                                <div class="panel-heading" id="panelCadastroHead" style="cursor:pointer;">Professor</div>
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

                                                <label for="re" class="control-label col-lg-2">R.E.:</label>
                                                <input type="text" class="form-control col-lg-4" id="re" name="re" placeholder="R.E.">

                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-inline">                                                  
                                                <label for="usuario" class="control-label col-lg-2">Usuário:</label>
                                                <input type="text" class="form-control col-lg-4" id="usuario" name="usuario" placeholder="Usuário">

                                                <label for="senha" class="control-label col-lg-2">Senha:</label>
                                                <input type="password" class="form-control col-lg-4" id="senha" name="senha" placeholder="Senha">
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="form-inline">
                                                <label for="file" class="control-label col-lg-2">Carregar Foto:</label>
                                                <input name="file" class="form-control-static col-lg-4" id="file" type="file" />
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
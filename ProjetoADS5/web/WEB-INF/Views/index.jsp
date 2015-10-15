<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-12" id="alertbar">
                <div class="alert alert-info alert-dismissable">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <i class="fa fa-info-circle"></i>  <strong>Mensagem</strong> Teste
                </div>
            </div>
        </div>
        <!-- /.row -->

        <div class="row">

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel-body">
                        <div class="table-condensed">
                            <table class="table table-condensed table-hover table-responsive table-striped">
                                <thead>
                                    <tr>
                                        <th class="col-sm-1">Nº</th>
                                        <th class="col-sm-3">Solicitante</th>
                                        <th class="col-sm-2">Titulo</th>
                                        <th class="col-sm-2">Tipo</th>
                                        <th class="col-sm-2">SLA</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        <div class="text-right">
                            <a href="#"><i class="fa fa-arrow-circle-right"></i></a>
                        </div>
                    </div>
                </div>
            </div>    

    </body>

</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>${ViewName}</title>
        <c:import url="/WEB-INF/Views/Layout/head-essential.jsp" />
        <script src="additional/CoreGenerico.js" type="text/javascript"></script>
    </head>
    <body>

        <div id="wrapper">
            <c:import url="/WEB-INF/Views/Layout/top-wrapper.jsp" />
            <div id="page-wrapper">
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                ${ViewName} <small>${ViewDescription}</small>
                            </h1>                           
                        </div>
                    </div>
                    <!-- /.row -->

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel-body">
                                <div class="table-condensed">
                                    <table id="listagem-CoreGenerico" class="table table-condensed table-hover table-responsive table-striped">                                      
                                    </table>
                                </div>
                            </div>
                        </div> 
                    </div>

                    <c:import url="/WEB-INF/Views/Layout/footer.jsp" />

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

    </div>

</body>

</html>
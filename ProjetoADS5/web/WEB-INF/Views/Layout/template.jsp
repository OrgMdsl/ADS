<%-- 
    Document   : template
    Created on : 14/10/2015, 23:35:36
    Author     : matheusdsl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title><decorator:title /></title>
        <c:import url="/WEB-INF/Views/Layout/head-essential.jsp" />
        <decorator:head />
    </head>
    <body>

        <div id="wrapper">
            <c:import url="/WEB-INF/Views/Layout/top-wrapper.jsp" />
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                <decorator:title />
                            </h1>                           
                        </div>
                    </div>
                    <!-- /.row -->
                    <decorator:body />

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

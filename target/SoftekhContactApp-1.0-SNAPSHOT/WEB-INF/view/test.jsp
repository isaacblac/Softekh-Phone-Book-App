<%-- 
    Document   : test
    Created on : 22-Jul-2018, 16:20:41
    Author     : ISAAC BLACK
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <s:url var="url_jqlib" value="/static/js/jquery.js"/>
        <script src="${url_jqlib}"></script>
        <script>
            $(document).ready(function(){
                //alert('JQuery is integrated and ready!');
                $("#id_get_time").click(function(){
                   // alert('Button Clicked....');
                   $.ajax({
                       url : 'get_time',
                       success : function(data){
                           $("#id_time").html(data);
                       }
                   });
                });
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>AJAX Test Page</h1>
        <button id="id_get_time">Get Server Time</button><br/>
        <p id="id_time"></p>
    </body>
</html>

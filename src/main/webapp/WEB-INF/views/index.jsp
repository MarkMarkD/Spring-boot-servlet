<%-- 
    Document   : index
    Created on : 10.05.2018, 17:21:49
    Author     : banashko.dv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Welcome to list of parts project!</h3>
        
        <form method="get" action="/list">
            <button type="submit">List all parts</button>
        </form>
        
        <br>
        
        <form method="get" action="/addPart/">
            <button type="submit">Add new part</button>
        </form>
    </body>
</html>

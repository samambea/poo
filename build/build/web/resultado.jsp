<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Confirmação</title>
    </head>
    <body>
        <%String msg = (String) request.getAttribute("msg");%>
        <h1>Mensagem do Sistema: <%out.print(msg);%></h1>  
        <a href="index.html">Voltar</a>
    </body>
</html>

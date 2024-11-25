<!-- consultaID.jsp -->

<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Estoque</title>
    </head>
    <body>
        <h1>Consultar Estoque Disponível - Por Cadastro</h1>
        <h2>
            <%Book b = (Book) request.getAttribute("book");%>

            <%
                if (b != null) {
                b.getBookId();
            %>
            ID......................: <%out.println(b.getBookId());%><BR>
            Nome do Livro...........: <%out.println(b.getBookName());%><BR>
            Autor(es)...............: <%out.println(b.getAuthors());%><BR>
            Gênero..................: <%out.println(b.getGenre());%><BR>
            Editora.................: <%out.println(b.getPublisher());%><BR>
            Ano de Publicação.......: <%out.println(b.getYearPublished());%><BR>
            Edição..................: <%out.println(b.getEdition());%><BR>
            Quantidade em Estoque...: <%out.println(b.getQtdInStock());%><BR>
            Avaliação...............: <%out.println(b.getRating());%><BR>
            Preço...................: <%out.println(b.getPrice());%><BR>
            <%} else {%>
            Livro não encontrado.
            <%}%>
        </h2>
    </body>
</html>

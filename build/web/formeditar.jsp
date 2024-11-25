<!--formeditar.jsp -->

<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Estoque</title>
    </head>
    <body>
        <h1>Alterar Estoque Disponível</h1>
        <h2>
            <% Book b = (Book) request.getAttribute("book"); %>

            <%
                if (b != null) {
            %>

            <form action="C" method="POST">
                ID......................:<input type="text" name="txtBookId" value="<%out.println(b.getBookId());%>"><BR>
                Autor(es)...............:<input type="text" name="txtauthors" value="<%out.println(b.getAuthors());%>"><BR>
                Nome do Livro...........:<input type="text" name="txtbookName" value="<%out.println(b.getBookName());%>"><BR>
                Gênero..................:<input type="text" name="txtgenre" value="<%out.println(b.getGenre());%>"><BR>
                Editora.................:<input type="text" name="txtpublisher" value="<%out.println(b.getPublisher());%>"><BR>
                Ano de Publicação.......:<input type="text" name="txtyearPublished" value="<%out.println(b.getYearPublished());%>"><BR>
                Edição..................:<input type="text" name="txtedition" value="<%out.println(b.getEdition());%>"><BR>
                Quantidade em Estoque...:<input type="text" name="txtqtdInStock" value="<%out.println(b.getQtdInStock());%>"><BR>
                Avaliação...............:<input type="text" name="txtrating" value="<%out.println(b.getRating());%>"><BR>
                Preço...................:<input type="text" name="txtprice" value="<%out.println(b.getPrice());%>"><BR>
                <input type="submit" name="btnop" value="ATUALIZAR">    
                <%} else {%>
                ID NÃO ENCONTRADO
                <%}%>
            </form>

        </h2>
    </body>
</html>

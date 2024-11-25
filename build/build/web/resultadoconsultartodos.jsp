<%@page import="java.util.List"%>
<%@page import="model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Estoque Total</title>
    </head>
    <h1>Estoque Disponível</h1>
    <table border="1">
        <tr>
          <th>ID</th>
          <th>Nome do Livro</th>
          <th>Autor(es)</th>
          <th>Gênero</th>
          <th>Editora</th>
          <th>Ano de Publicação</th>
          <th>Edição</th>
          <th>Quantidade em Estoque</th>
          <th>Avaliação</th>
          <th>Preço</th>
        </tr>
        <%
          List<Book> lbook = (List<Book>) request.getAttribute("lbook");
          for (Book b : lbook) {
        %>
        <tr>
            <td style="text-align: center"><%out.println(b.getBookId());%></td>
          <td><%out.println(b.getBookName());%></td>
          <td style="text-align: center"><%out.println(b.getAuthors());%></td>
          <td style="text-align: center"><%out.println(b.getGenre());%></td>
          <td style="text-align: center"><%out.println(b.getPublisher());%></td>
          <td style="text-align: center"><%out.println(b.getYearPublished());%></td>
          <td style="text-align: center"><%out.println(b.getEdition());%></td>
          <td style="text-align: center"><%out.println(b.getQtdInStock());%></td>
          <td style="text-align: center"><%out.println(b.getRating());%></td>
          <td style="text-align: center"><%out.println(b.getPrice());%></td>
        </tr>
        <%}%>
</table>
</html>

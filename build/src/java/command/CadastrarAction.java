package command;

import dao.BookDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

public class CadastrarAction implements InterfaceCommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String msg = "";
    BookDAO dao = new BookDAO();
    Book b = new Book();
        try {
            int bookId = Integer.parseInt(request.getParameter("txtBookId"));
            String authors = request.getParameter("txtauthors");
            String bookName = request.getParameter("txtbookName");
            String genre = request.getParameter("txtgenre");
            String publisher = request.getParameter("txtpublisher");
            String yearPublished = request.getParameter("txtyearPublished");
            String edition = request.getParameter("txtedition");
            int qtdInStock = Integer.parseInt(request.getParameter("txtqtdInStock"));
            float rating = Float.parseFloat(request.getParameter("txtrating"));
            String price  = request.getParameter("txtprice");
                   
            b.setBookId(bookId);
            b.setAuthors(authors);
            b.setBookName(bookName);
            b.setGenre(genre);
            b.setPublisher(publisher);
            b.setYearPublished(yearPublished);
            b.setEdition(edition);
            b.setQtdInStock(qtdInStock);
            b.setRating(rating);
            b.setPrice(price);
            
            dao.cadastrar(b);
            msg = "Cadastrado com sucesso.";
            System.out.println("Cadastrado com sucesso.");
        } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
            msg = "Erro ao cadastrar."  + ex.getMessage();
            System.out.println("ERRO: " + ex.getMessage());
        }
        request.setAttribute("msg", msg);
        return "resultado.jsp";    
    }
}

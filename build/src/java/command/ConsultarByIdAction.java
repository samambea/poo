package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import dao.BookDAO;
import java.sql.SQLException;

public class ConsultarByIdAction implements InterfaceCommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = "";
        BookDAO dao = new BookDAO();
        Book b = new Book();
        try {
            int bookId = Integer.valueOf(request.getParameter("txtBookId"));
            b.setBookId(bookId);
            Book book = dao.consultarById(b);
            request.setAttribute("book", book);
        } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
            msg = "Erro ao consultar"+ ex.getMessage();
            System.out.println("ERRO: " + ex.getMessage());
            request.setAttribute("msg", msg);
        }
        return "consultaID.jsp";
    }
    
}

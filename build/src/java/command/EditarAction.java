package command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import dao.BookDAO;

public class EditarAction implements InterfaceCommand{
    
     @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = "";
        BookDAO dao = new BookDAO();
        Book b = new Book();
        try {
            int id = Integer.parseInt(request.getParameter("txtBookId"));
            b.setBookId(id);
            Book book = dao.consultarById(b);
            request.setAttribute("book", book);
        } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
            msg = "Erro ao consultar" + ex.getMessage();
            request.setAttribute("msg", msg);
            System.out.println("ERRO: " + ex.getMessage());
        }
        return "formeditar.jsp";
    }
    
}

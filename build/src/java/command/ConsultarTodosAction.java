package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import dao.BookDAO;
import java.sql.SQLException;
import java.util.List;

public class ConsultarTodosAction implements InterfaceCommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BookDAO dao = new BookDAO();
        try {
            List<Book> lbook = dao.consultarTodos();
            request.setAttribute("lbook", lbook);
        } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
            System.out.println("ERRO: " + ex.getMessage());
        }
        return "resultadoconsultartodos.jsp";
    }
    
}

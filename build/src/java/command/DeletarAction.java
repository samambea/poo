package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;
import dao.BookDAO;
import java.sql.SQLException;

public class DeletarAction implements InterfaceCommand{

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String msg = "";
        BookDAO dao = new BookDAO();
        Book b = new Book();
        try {
            int bookId = Integer.parseInt(request.getParameter("txtBookId"));
            b.setBookId(bookId);
            dao.deletar(b);
            msg = "Deletado com sucesso.";
            System.out.println("Deletado com sucesso.");
        } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
            msg = "Erro ao deletar." + ex.getMessage();
            System.out.println("ERRO: " + ex.getMessage());
        }
        request.setAttribute("msg", msg);
        return "resultado.jsp";
    }
}

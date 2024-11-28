//BookControl.java

package controller;

import command.InterfaceCommand;
import dao.BookDAO;
import model.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "C", urlPatterns = {"/C"})
public class BookControltest extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //String op = request.getParameter("btnop");
            BookDAO bDAO = new BookDAO();
            Book b = new Book();
            try {
                String paramAction = request.getParameter("btnop");
                
                String nomeDaClasse = "command."+paramAction+"Action";
                Class classAction = Class.forName(nomeDaClasse);                
                InterfaceCommand commandAction = (InterfaceCommand) classAction.newInstance();
                
                String pageAction = commandAction.executar(request, response);
                request.getRequestDispatcher(pageAction).forward(request, response);
            } catch (Exception e) {
                String msg = "Erro Genérico";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("resultado.jsp").forward(request, response);
            }
        }
    }
}

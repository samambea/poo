//BookControl.java

package controller;

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
public class BookControl extends HttpServlet {
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
            String msg = "";

            String op = request.getParameter("btnop");
            BookDAO bDAO = new BookDAO();
            Book b = new Book();
            switch (op) {
                case "CADASTRAR" -> {
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
                        
                       var book = new Book.BookBuilder()
                                        .setBookId(bookId)
                                        .setAuthors(authors)
                                        .setBookName(bookName)
                                        .setGenre(genre)
                                        .setPublisher(publisher)
                                        .setYearPublished(yearPublished)
                                        .setEdition(edition)
                                        .setQtdInStock(qtdInStock)
                                        .setRating(rating)
                                        .setPrice(price)
                                        .build();
                                           
                        bDAO.cadastrar(book);
                        msg = "Cadastrado com sucesso.";
                        System.out.println("Cadastrado com sucesso.");
                    } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                        msg = "Erro ao cadastrar." + ex.getMessage();
                        System.out.println("ERRO: " + ex.getMessage());
                    }   request.setAttribute("msg", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                }
                case "EDITAR" -> {
                    try {
                        int id = Integer.parseInt(request.getParameter("txtBookId"));
                        b.setBookId(id);
                        Book book = bDAO.consultarById(b);
                        request.setAttribute("book", book);
                        request.getRequestDispatcher("formeditar.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                        msg = "Erro ao consultar"+ ex.getMessage();
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
                case "ATUALIZAR" -> {
                    try {
                        int bookId = Integer.parseInt(request.getParameter("txtBookId"));
                        System.out.println(request.getParameter("txtBookId"));
                        String authors = request.getParameter("txtauthors");
                        String bookName = request.getParameter("txtbookName");
                        String genre = request.getParameter("txtgenre");
                        String publisher = request.getParameter("txtpublisher");
                        String yearPublished = request.getParameter("txtyearPublished");
                        String edition = request.getParameter("txtedition");
                        int qtdInStock = Integer.parseInt(request.getParameter("txtqtdInStock"));
                        float rating = Float.parseFloat(request.getParameter("txtrating"));
                        String price  = request.getParameter("txtprice");
                        
                        var book = new Book.BookBuilder()
                                        .setBookId(bookId)
                                        .setAuthors(authors)
                                        .setBookName(bookName)
                                        .setGenre(genre)
                                        .setPublisher(publisher)
                                        .setYearPublished(yearPublished)
                                        .setEdition(edition)
                                        .setQtdInStock(qtdInStock)
                                        .setRating(rating)
                                        .setPrice(price)
                                        .build();
                        
                        bDAO.atualizar(book);
                        
                        msg = "Atualizado com sucesso.";
                        System.out.println("Atualizado com sucesso.");
                    } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                        msg = "Erro ao Atualizar. "+ ex.getMessage() + String.valueOf(b);
                        System.out.println("ERRO: " + ex.getMessage());
                    }   request.setAttribute("msg", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                }
                case "DELETAR" -> {
                    try {
                        int bookId = Integer.parseInt(request.getParameter("txtBookId"));
                        
                        var book = new Book.BookBuilder()
                                        .setBookId(bookId)
                                        .build();

                        bDAO.deletar(book);
                        msg = "Deletado com sucesso.";
                        System.out.println("Deletado com sucesso.");
                    } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                        msg = "Erro ao deletar." + ex.getMessage();
                        System.out.println("ERRO: " + ex.getMessage());
                    }   request.setAttribute("msg", msg);
                    request.getRequestDispatcher("resultado.jsp").forward(request, response);
                }
                case "CONSULTARBYID" -> {
                    try {
                        Integer bookId = Integer.valueOf(request.getParameter("txtBookId"));
                        
                        var bk = new Book.BookBuilder()
                                        .setBookId(bookId)
                                        .build();
                        
                        Book book = bDAO.consultarById(bk);
                        request.setAttribute("book", book);
                        request.getRequestDispatcher("consultaID.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                        msg = "Erro ao consultar" + ex.getMessage();
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
                case "CONSULTARTODOS" -> {
                    try {
                        List<Book> lbook = bDAO.consultarTodos();
                        request.setAttribute("lbook", lbook);
                        request.getRequestDispatcher("resultadoconsultartodos.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException | NumberFormatException ex) {
                        System.out.println("ERRO: " + ex.getMessage());
                    }
                }
                default -> {
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

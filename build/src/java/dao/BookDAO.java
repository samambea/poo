//BookDAO.java

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import util.Conn;

public class BookDAO {
   
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        return Conn.getConexaoMySQL();
    }
    
    public void cadastrar(Book b) throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("INSERT INTO books (authors, bookName, genre, publisher, yearPublished, edition, qtdInStock, rating, price) VALUES (?,?,?,?,?,?,?,?,?)");
        comando.setString(1,  b.getAuthors());
        comando.setString(2,  b.getBookName());
        comando.setString(3,  b.getGenre());
        comando.setString(4,  b.getPublisher());
        comando.setString(5,  b.getYearPublished());
        comando.setString(6,  b.getEdition());
        comando.setInt(7,  b.getQtdInStock());
        comando.setFloat(8,  b.getRating());
        comando.setString(9,  b.getPrice());
        comando.execute();
        con.close();
    }
    
    public void deletar(Book b) throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("DELETE FROM books WHERE bookId = ?");
        comando.setInt(1, b.getBookId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Book b) throws ClassNotFoundException, SQLException {
        if(b != null){
            Connection con = getConexao();
            PreparedStatement comando = con.prepareStatement("UPDATE books SET authors = ?, bookName = ?, genre = ?, publisher = ?, yearPublished = ?, edition = ?, qtdInStock = ?, rating = ?, price = ? WHERE bookId = ?");
            comando.setString(1,  b.getAuthors());
            comando.setString(2,  b.getBookName());
            comando.setString(3,  b.getGenre());
            comando.setString(4,  b.getPublisher());
            comando.setString(5,  b.getYearPublished());
            comando.setString(6,  b.getEdition());
            comando.setInt(7,  b.getQtdInStock());
            comando.setFloat(8,  b.getRating());
            comando.setString(9,  b.getPrice());
            comando.setInt(10, b.getBookId());
            comando.execute();
            con.close();
        }
    }    
    
    public Book consultarById(Book b) throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM books WHERE bookId = ?");
        comando.setInt(1, b.getBookId());
        ResultSet rs = comando.executeQuery();
        Book bk = new Book();
        if (rs.next()) {
            bk.setBookId(rs.getInt("bookId"));
            bk.setAuthors(rs.getString("authors"));
            bk.setBookName(rs.getString("bookName"));
            bk.setGenre(rs.getString("genre"));
            bk.setPublisher(rs.getString("publisher"));
            bk.setYearPublished(rs.getString("yearPublished"));
            bk.setEdition(rs.getString("edition"));
            bk.setQtdInStock(rs.getInt("qtdInStock"));
            bk.setRating(rs.getFloat("rating"));
            bk.setPrice(rs.getString("price"));
        }       
        con.close();
        return bk;
    }
    
    public List<Book> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("SELECT * FROM books");        
        ResultSet rs = comando.executeQuery();        
        List<Book> lbook = new ArrayList<Book>();
        int cont = 0;
        while(rs.next()){
            Book b = new Book();
            b.setBookId(rs.getInt("bookId"));
            b.setAuthors(rs.getString("authors"));
            b.setBookName(rs.getString("bookName"));
            b.setGenre(rs.getString("genre"));
            b.setPublisher(rs.getString("publisher"));
            b.setYearPublished(rs.getString("yearPublished"));
            b.setEdition(rs.getString("edition"));
            b.setQtdInStock(rs.getInt("qtdInStock"));
            b.setRating(rs.getFloat("rating"));
            b.setPrice(rs.getString("price")); 
            lbook.add(b);
            cont++;
        }
        System.out.println("Cont..: " + cont);
        con.close();
        return lbook;
    }    
}

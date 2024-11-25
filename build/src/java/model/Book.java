//Book.java

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bAlmeida
 */
@Entity
@Table(name = "books")

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookId")
    private int bookId;
    
    @Basic(optional = false)
    @Column(name = "authors")
    private String authors;
    
    @Basic(optional = false)
    @Column(name = "bookName")
    private String bookName;
    
    @Basic(optional = false)
    @Column(name = "genre")
    private String genre;
    
    @Basic(optional = false)
    @Column(name = "publisher")
    private String publisher;
    
    @Basic(optional = false)
    @Column(name = "yearPublished")
    private String yearPublished;
    
    @Basic(optional = false)
    @Column(name = "edition")
    private String edition;
    
    @Basic(optional = false)
    @Column(name = "qtdInStock")
    private int qtdInStock;
    
    //@Max(value=5.0) 
    //@Min(value=0.0)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "rating")
    private float rating;
    
    @Basic(optional = false)
    @Column(name = "price")
    private String price;

    public Book() {
    }

    public Book(int bookId) {
        this.bookId = bookId;
    }

    private Book(BookBuilder builder) {
        this.bookId = builder.bookId;
        this.authors = builder.authors;
        this.bookName = builder.bookName;
        this.genre = builder.genre;
        this.publisher = builder.publisher;
        this.yearPublished = builder.yearPublished;
        this.edition = builder.edition;
        this.qtdInStock = builder.qtdInStock;
        this.rating = builder.rating;
        this.price = builder.price;
    }
    
    public Book(int bookId, String authors, String bookName, String genre, String publisher, String yearPublished, String edition, int qtdInStock, float rating, String price) {
        this.bookId = bookId;
        this.authors = authors;
        this.bookName = bookName;
        this.genre = genre;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.edition = edition;
        this.qtdInStock = qtdInStock;
        this.rating = rating;
        this.price = price;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getQtdInStock() {
        return qtdInStock;
    }

    public void setQtdInStock(int qtdInStock) {
        this.qtdInStock = qtdInStock;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "model.Books[ bookId=" + bookId + " ]";
    }
    
    /////////////////BUILDER////////////////////
    public static class BookBuilder {
        private int bookId;
        private String authors;
        private String bookName;
        private String genre;
        private String publisher;
        private String yearPublished;
        private String edition;
        private int qtdInStock;
        private float rating;
        private String price;

        public BookBuilder setBookId(int bookId) {
            this.bookId = bookId;
            return this;
        }

        public BookBuilder setAuthors(String authors) {
            this.authors = authors;
            return this;
        }
        
        public BookBuilder setBookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public BookBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }
        
        public BookBuilder setPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }
        
        public BookBuilder setYearPublished(String yearPublished) {
            this.yearPublished = yearPublished;
            return this;
        }
        
        public BookBuilder setEdition(String edition) {
            this.edition = edition;
            return this;
        }
        
        public BookBuilder setQtdInStock(int qtdInStock) {
            this.qtdInStock = qtdInStock;
            return this;
        }

        public BookBuilder setRating(float rating) {
            this.rating = rating;
            return this;
        }
        
        public BookBuilder setPrice(String price) {
            this.price = price;
            return this;
        }
        
        public Book build() {
            return new Book(this);
        }
    }
    
    
}

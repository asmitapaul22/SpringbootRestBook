package com.api.book.bootrestbook.services;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookService {
@Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(12,"java ref","xyz"));
    //     list.add(new Book(1222,"java main","adjh"));
    //     list.add(new Book(12333,"java quesbank","uuyz"));
    // }
    //GET ALL BOOKS
    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    //GET SINGLE BOOK BY ID
    public Book getBookById(int id)
    {
        Book book= null;
        try{
            // book=list.stream().filter(e->
            // e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id); 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
            return book;

    }
    //CREATE-adding the new book
    public Book addBook(Book b)
    {
        // list.add(b);
        // return b;
       Book result= this.bookRepository.save(b);
       return result;
    }

    //delete book
    public void deleteBook(int bid)
    {
        // list= list.stream().filter(e -> e.getId() != bid).collect(Collectors.toList());
        this.bookRepository.deleteById(bid);
            
    }
    //update book
    public void updateBook(Book book,int bookId)
    {
        // list.stream().map(b->{
        //     if(b.getId()==bookId)
        //     {
        //         b.setTitle(book.getTitle());
        //         b.setAuthor(book.getAuthor());
        //     }
        //     return b; 
        // }).collect(Collectors.toList());
        book.setId(bookId);
        this.bookRepository.save(book);
    }
}

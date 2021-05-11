package com.example.library.studentlibrary.Services;

import com.example.library.studentlibrary.Model.Book;
import com.example.library.studentlibrary.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        if(genre != null && author != null){
            return bookRepository.findBooksByGenreAuthor(genre, author, available);
        }else if(genre != null){
            return bookRepository.findBooksByGenre(genre, available);
        }else if(author != null){
            return bookRepository.findBooksByAuthor(author, available);
        }else{
            return bookRepository.findByAvailability(available);
        }


    }




}

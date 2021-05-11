package com.example.library.studentlibrary.Services;

import com.example.library.studentlibrary.Model.Author;
import com.example.library.studentlibrary.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void create(Author author){
        authorRepository.save(author);
    }
}

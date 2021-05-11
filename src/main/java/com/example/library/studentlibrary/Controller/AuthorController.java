package com.example.library.studentlibrary.Controller;

import com.example.library.studentlibrary.Model.Author;
import com.example.library.studentlibrary.Services.AuthorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/")
    public ResponseEntity createAuthor(@RequestBody Author author){

        authorService.create(author);
        return new ResponseEntity<>("the author is successfully added to the system", HttpStatus.CREATED);

    }


}

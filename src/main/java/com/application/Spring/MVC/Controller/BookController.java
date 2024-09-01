package com.application.Spring.MVC.Controller;

import com.application.Spring.MVC.Interface.BookRepository;
import com.application.Spring.MVC.Utils.Model.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class BookController {

    private static Logger logger = LoggerFactory.getLogger(TutorialController.class);

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/BooksDetails")
    public ResponseEntity<List<Books>> getBooksDetails(@RequestParam(required = false) String name){
        List<Books> books=new ArrayList<>();
        if (name==null){
            books.addAll(bookRepository.findAll());
        }
        else {
            books.add((Books) bookRepository.findByName(name));
        }
        if (books.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PostMapping("/AddBook")
    public ResponseEntity createBook(@RequestBody Books books){
        try {
            Books books1=bookRepository.save(new Books(books.getName(),books.getAuthor()));
            return new ResponseEntity<>(books1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

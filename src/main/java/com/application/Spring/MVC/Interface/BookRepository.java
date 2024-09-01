package com.application.Spring.MVC.Interface;

import com.application.Spring.MVC.Utils.Model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Books,Integer> {
    List<Books> findByName(String name);
}

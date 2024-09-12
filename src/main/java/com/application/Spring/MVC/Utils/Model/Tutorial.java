package com.application.Spring.MVC.Utils.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="tutorial")
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column( name = "title")
    private String title;

    @Column( name = "description")
    private String description;

    @Column(name = "published")
    private boolean published;


    @JoinColumn(name="book_id",referencedColumnName = "id")
    @OneToMany
    List<Books> books;

    public Tutorial() {

    }

    public Tutorial(String title, String description, boolean published, List<Books> books) {
        this.title = title;
        this.description = description;
        this.published = published;
        this.books = books;
    }

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean isPublished) {
        this.published = isPublished;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks() {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }


}

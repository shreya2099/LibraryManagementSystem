package com.example.library.studentlibrary.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
     private int id;

     private String name;

     @Enumerated(EnumType.STRING)
     private Genre genre;

     @ManyToOne
     @JoinColumn
     @JsonIgnoreProperties("booksWritten")
     private Author author;

     @OneToOne
     @JoinColumn
     @JsonIgnoreProperties("books")
     private Card card;

     @Column(columnDefinition = "TINYINT(1)")
     private boolean available;

     @OneToMany(mappedBy= "book", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
     @JsonIgnoreProperties("Book")
     private List<Transaction> transactions;

     public Book(){

     }

    public Book(int id, String name, Genre genre, Author author, Card card, boolean available, List<Transaction> transactions) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.card = card;
        this.available = available;
        this.transactions = transactions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
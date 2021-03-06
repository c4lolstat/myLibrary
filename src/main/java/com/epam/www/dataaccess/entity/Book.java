package com.epam.www.dataaccess.entity;

import javax.persistence.*;

/**
 * Created by Farkas on 2017.02.23..
 */

@Entity
@Table(name = "Library")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String isbn;
    private String author;
    private String title;
    private boolean deleted;
    private String lendingFromDate;
    private String lendingToDate;
    private String lendedTo;
    private boolean lended;

    public String getLendingFromDate() {
        return lendingFromDate;
    }

    public void setLendingFromDate(String lendingFromDate) {
        this.lendingFromDate = lendingFromDate;
    }

    public String getLendingToDate() {
        return lendingToDate;
    }

    public void setLendingToDate(String lendingToDate) {
        this.lendingToDate = lendingToDate;
    }

    public String getLendedTo() {
        return lendedTo;
    }

    public void setLendedTo(String lendedTo) {
        this.lendedTo = lendedTo;
    }

    public boolean isLended() {
        return lended;
    }

    public void setLended(boolean lended) {
        this.lended = lended;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

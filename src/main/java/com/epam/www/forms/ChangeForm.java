package com.epam.www.forms;

import javax.validation.constraints.Size;

/**
 * Created by Farkas on 2017.10.22..
 */
public class ChangeForm {

    private int id;
    @Size(min = 1, message = "Title should not be empty")
    private String title;
    @Size(min = 1, message = "Author should not be empty")
    private String author;
    @Size(min = 1, message = "ISBN should not be empty")
    private String isbn;

    private boolean deleted;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}

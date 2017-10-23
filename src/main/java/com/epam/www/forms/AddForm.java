package com.epam.www.forms;

import javax.validation.constraints.Size;

/**
 * Created by Farkas on 2017.10.20..
 */
public class AddForm {

    @Size(min = 1, message = "Title should not be empty")
    private String title;
    @Size(min = 1, message = "Author should not be empty")
    private String author;
    @Size(min = 1, message = "ISBN should not be empty")
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
}

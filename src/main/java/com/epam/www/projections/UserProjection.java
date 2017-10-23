package com.epam.www.projections;

/**
 * Created by Farkas on 2017.10.22..
 */
public class UserProjection {

    private int id;
    private String title;
    private String author;
    private boolean lended;
    private String lendedTo;
    private String lendingToDate;

    public UserProjection(int id, String author, String title, boolean lended, String lendedTo, String lendingToDate){
        this.id = id;
        this.title = title;
        this.author = author;
        this.lended = lended;
        this.lendedTo = lendedTo;
        this.lendingToDate = lendingToDate;
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

    public boolean isLended() {
        return lended;
    }

    public void setLended(boolean lended) {
        this.lended = lended;
    }
}

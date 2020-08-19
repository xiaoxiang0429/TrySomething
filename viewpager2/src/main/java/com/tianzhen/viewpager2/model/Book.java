package com.tianzhen.viewpager2.model;

import java.io.Serializable;

public class Book implements Serializable {

    public Book(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    private String title;
    private String content;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

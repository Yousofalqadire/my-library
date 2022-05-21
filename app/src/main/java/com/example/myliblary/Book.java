package com.example.myliblary;

import android.net.Uri;

public class Book {
    private int id;
    private String Name;
    private String author;
    private String ImageUrl;
    private String Description;
    private int Pages;

    public Book(int id, String name, String author, String imageUrl, String description, int pages) {
        this.id = id;
        Name = name;
        this.author = author;
        ImageUrl = imageUrl;
        Description = description;
        Pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Name='" + Name + '\'' +
                ", author='" + author + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}

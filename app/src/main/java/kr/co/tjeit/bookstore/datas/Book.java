package kr.co.tjeit.bookstore.datas;

import java.io.Serializable;

/**
 * Created by the on 2017-07-25.
 */

public class Book implements Serializable {
    private String title;
    private String authorName;
    private String publisherName;
    private int cost;

    public int getBookImgId() {
        return bookImgId;
    }

    public void setBookImgId(int bookImgId) {
        this.bookImgId = bookImgId;
    }

    private  int bookImgId;
    public Book() {

    }

    @Override
    public String toString() {
        String str = "title=" + title + ", authorName=" + authorName + ", publisherName=" + publisherName + ", cost=" + cost;
        return str;
    }

    public Book(String title, String authorName, String publisherName, int cost, int bookImgId) {
        this.title = title;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.cost = cost;
        this.bookImgId = bookImgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

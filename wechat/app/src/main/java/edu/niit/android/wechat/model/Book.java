package edu.niit.android.wechat.model;

/**
 * Created by Jay on 2015/9/22 0022.
 */
public class Book {
    private String bName;
    private String bAuthor;

    public Book() {
    }

    public Book(String bName, String bAuthor) {
        this.bName = bName;
        this.bAuthor = bAuthor;
    }

    public String getbName() {
        return bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }
}

package edu.niit.android.wechat.model;

import java.io.Serializable;

public class Message implements Serializable {
    private int headerId;
    private String title;
    private String subTitle;
    private String time;
    private boolean isRead;

    public Message(int headerId, String title, String subTitle, String time, boolean isRead) {
        this.headerId = headerId;
        this.title = title;
        this.subTitle = subTitle;
        this.time = time;
        this.isRead = isRead;
    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "Message{" +
                "headerId=" + headerId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", time='" + time + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}

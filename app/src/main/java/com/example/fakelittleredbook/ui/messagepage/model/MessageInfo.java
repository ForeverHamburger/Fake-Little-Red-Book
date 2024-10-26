package com.example.fakelittleredbook.ui.messagepage.model;

public class MessageInfo {
    private int icon;
    private String title;
    private String simpleMessage;
    private String date;

    public MessageInfo(int icon, String title, String simpleMessage, String date) {
        this.icon = icon;
        this.title = title;
        this.simpleMessage = simpleMessage;
        this.date = date;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }

    public void setSimpleMessage(String simpleMessage) {
        this.simpleMessage = simpleMessage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

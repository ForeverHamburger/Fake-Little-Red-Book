package com.example.fakelittleredbook.ui.mypage.model;

public class MyInfo {
    private int profilePicture;
    private String userName;
    private String userId;
    private String IPPosition;
    private String simpleInfo;
    private int attentionCount;
    private int followerCount;
    private int loveAndCollection;
    private int background;

    public MyInfo(int profilePicture, String userName, String userId
            , String IPPosition, String simpleInfo, int attentionCount
            , int followerCount, int loveAndCollection, int background) {
        this.profilePicture = profilePicture;
        this.userName = userName;
        this.userId = userId;
        this.IPPosition = IPPosition;
        this.simpleInfo = simpleInfo;
        this.attentionCount = attentionCount;
        this.followerCount = followerCount;
        this.loveAndCollection = loveAndCollection;
        this.background = background;
    }

    public String getSimpleInfo() {
        return simpleInfo;
    }

    public void setSimpleInfo(String simpleInfo) {
        this.simpleInfo = simpleInfo;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIPPosition() {
        return IPPosition;
    }

    public void setIPPosition(String IPPosition) {
        this.IPPosition = IPPosition;
    }

    public int getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(int attentionCount) {
        this.attentionCount = attentionCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getLoveAndCollection() {
        return loveAndCollection;
    }

    public void setLoveAndCollection(int loveAndCollection) {
        this.loveAndCollection = loveAndCollection;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}

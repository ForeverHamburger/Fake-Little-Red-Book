package com.example.fakelittleredbook.ui.shortvideopage.model;

public class CommentsInfo {
    private String commentName;
    private String commentContext;
    private String commentLikeCount;
    private Integer commentIcon;

    public CommentsInfo(String commentName, String commentContext, String commentLikeCount, Integer commentIcon) {
        this.commentName = commentName;
        this.commentContext = commentContext;
        this.commentLikeCount = commentLikeCount;
        this.commentIcon = commentIcon;
    }

    public String getCommentName() {
        return commentName;
    }

    public void setCommentName(String commentName) {
        this.commentName = commentName;
    }

    public String getCommentContext() {
        return commentContext;
    }

    public void setCommentContext(String commentContext) {
        this.commentContext = commentContext;
    }

    public String getCommentLikeCount() {
        return commentLikeCount;
    }

    public void setCommentLikeCount(String commentLikeCount) {
        this.commentLikeCount = commentLikeCount;
    }

    public Integer getCommentIcon() {
        return commentIcon;
    }

    public void setCommentIcon(Integer commentIcon) {
        this.commentIcon = commentIcon;
    }
}

package com.udacity.course3.reviews.entity;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;


    @Column(name = "comment_text")
    private String commentText;

    @ManyToOne(targetEntity = Review.class)
    @JoinColumn(name= "review_id")
    private Review review;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Review getReviewId() {
        return review;
    }

    public  void setReviewId(Review review) {
        this.review = review;
    }
}


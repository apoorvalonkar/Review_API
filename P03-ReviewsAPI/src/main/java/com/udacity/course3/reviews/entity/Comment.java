package com.udacity.course3.reviews.entity;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;


    @Column(name = "comment_text")
    private String commentString;

    @ManyToOne
    @JoinColumn(name= "review_id")
    private Review review;

    public int getId() {
        return id;
    }

    public Review getReview() {
        return review;
    }

    public static void setReview(Review review) {
        this.review = review;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }


}

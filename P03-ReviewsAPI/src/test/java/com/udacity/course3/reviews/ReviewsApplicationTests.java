package com.udacity.course3.reviews;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repositories.CommentRepository;
import com.udacity.course3.reviews.repositories.ProductRepository;
import com.udacity.course3.reviews.repositories.ReviewRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	CommentRepository commentRepository;

	@Before
	public void setUp() {
		Product product = new Product();
		product.setProductName("new");
		productRepository.save(product);

		Review review = new Review();
		review.setProductId(product);
		review.setReviewTitle("some review");
		reviewRepository.save(review);

		Comment comment = new Comment();
		comment.setReviewId(review);
		comment.setCommentText("some comment");
		commentRepository.save(comment);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testReviewRepository() {
		Product someProduct = productRepository.findAll().get(0);
		List<Review> reviews = reviewRepository.findAllByProductId(someProduct.getProductId());

		assertNotNull(reviews);
		assertThat(reviews.get(0).getReviewTitle(), equalTo("some review"));
	}

	@Test
	public void testCommentRepository() {
		Review someReview = reviewRepository.findAll().get(0);
		List<Comment> comments = commentRepository.findAllByReviewId(someReview.getReviewId());

		assertNotNull(comments);
		assertThat(comments.get(0).getCommentText(), equalTo("some comment"));
	}


	@Test
	public void testFindProductbyReview() {
		Product someProduct = productRepository.findAll().get(0);
		Review someReview = reviewRepository.findAll().get(0);

		Product productFromReview = someReview.getProductId();

		assertEquals(someProduct, productRepository.findById(productFromReview.getProductId()).get());
	}

	@Test
	public void testFindReviewByComment() {
		Review someReview = reviewRepository.findAll().get(0);
		Comment someComment = commentRepository.findAll().get(0);

		Review reviewFromComment = someComment.getReviewId();

		assertEquals(someReview, reviewRepository.findById(reviewFromComment.getReviewId()).get());
	}

}
CREATE TABLE products(
    product_id INT AUTO_INCREMENT,
    product_name VARCHAR(255),
    CONSTRAINT product_pk PRIMARY KEY (product_id)
);

CREATE TABLE reviews(
    review_id INT AUTO_INCREMENT,
    title VARCHAR(1000),
    product_id INT,
    CONSTRAINT review_pk PRIMARY KEY (review_id),
    CONSTRAINT review_fk FOREIGN KEY(product_id)
    REFERENCES products(product_id)
);

CREATE TABLE comments(
    comment_id INT AUTO_INCREMENT,
    comment_text VARCHAR(1000),
    review_id INT,
    CONSTRAINT comment_pk PRIMARY KEY (comment_id),
    CONSTRAINT comment_fk FOREIGN KEY (review_id)
    REFERENCES reviews (review_id)
);
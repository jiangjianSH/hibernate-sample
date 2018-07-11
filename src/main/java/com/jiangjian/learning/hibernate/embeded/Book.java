package com.jiangjian.learning.hibernate.embeded;

import javax.persistence.*;

@AttributeOverrides({
        @AttributeOverride(
                name = "ebookPublisher.name",
                column = @Column(name = "ebook_publisher_name")
        ),
        @AttributeOverride(
                name = "paperBackPublisher.name",
                column = @Column(name = "paper_back_publisher_name")
        )
})
@AssociationOverrides({
        @AssociationOverride(
                name = "ebookPublisher.country",
                joinColumns = @JoinColumn(name = "ebook_publisher_country_id")
        ),
        @AssociationOverride(
                name = "paperBackPublisher.country",
                joinColumns = @JoinColumn(name = "paper_back_publisher_country_id")
        )
})
@Entity(name = "Book")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String author;

    @Embedded
    private Publisher ebookPublisher;

    @Embedded
    private Publisher paperBackPublisher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getEbookPublisher() {
        return ebookPublisher;
    }

    public void setEbookPublisher(Publisher ebookPublisher) {
        this.ebookPublisher = ebookPublisher;
    }

    public Publisher getPaperBackPublisher() {
        return paperBackPublisher;
    }

    public void setPaperBackPublisher(Publisher paperBackPublisher) {
        this.paperBackPublisher = paperBackPublisher;
    }
}
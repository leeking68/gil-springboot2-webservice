package com.gil.springboot.service.domain.posts;

import com.gil.springboot.service.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // auto add about getter method related to all field
@NoArgsConstructor // add default constructor
@Entity // this class will link with Table
public class Posts extends BaseTimeEntity {

    @Id // PK field of table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // rule of make PK. To auto_increment, have to add " ~.IDENTITY"
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // make a builder pattern class of this class
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}

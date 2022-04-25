package com.example.demo.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name="table_book",schema = "public")//schema="..."
public class Book {
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String title;
    private String author;
    private String genre;
    private String publisher;
}

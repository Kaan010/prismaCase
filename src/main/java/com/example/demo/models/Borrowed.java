package com.example.demo.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name="table_borrowed",schema = "public")//schema="..."
public class Borrowed {
    @Id
    @Column(name="borrowed_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;

    private String borrower_Name;
    private String book_name;

    private Date borrowedFrom;
    private Date borrowedTo;

}

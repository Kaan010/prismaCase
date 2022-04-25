package com.example.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name="table_user",schema = "public")//schema="..."
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    private String name;
    private String firstName;
    private Date memberSince;
    private Date memberTill;
    private String gender;
}

package com.example.myapp.model;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false,unique=true)
    private String email;
    @Column(nullable=false)
    private String password;
}

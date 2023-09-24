package com.springudemy.springsecurity.springsecurity.entity;

import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="name")
    private String name;

    public Role() {
    }

    public Role(String role) {
        this.name = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    
}

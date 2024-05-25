package com.santander.springWeb.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "destiny")
public class Destiny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    public void update(Destiny destiny) {
        this.setName(destiny.getName());
        this.setDescription(destiny.getDescription());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}




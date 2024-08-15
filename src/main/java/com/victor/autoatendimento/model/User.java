package com.victor.autoatendimento.model;


import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(columnDefinition = "varchar(50)")
    private String username;
    @Column(columnDefinition = "varchar(200)")
    private String password;
    @Column(columnDefinition = "tinyint(1)")
    private boolean enabled;


}

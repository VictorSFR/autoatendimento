package com.victor.mvc.autoatendimento.model;


import javax.persistence.*;

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

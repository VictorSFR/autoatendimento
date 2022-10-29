package com.victor.mvc.autoatendimento.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(columnDefinition="varchar(50)")
    private String username;
    @Column(columnDefinition="varchar(200)")
    private String password;
    @Column(columnDefinition="tinyint(1)")
    private boolean enabled;


}

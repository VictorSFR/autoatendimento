package com.victor.mvc.autoatendimento.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
@Table(name = "users")
public class User {
    @Id
    @ManyToOne
    @JoinColumn(name = "username",columnDefinition="varchar(50)")
    private Authority authority;
    @Column(columnDefinition="varchar(200)")
    private String password;

    private boolean enabled;


}

package com.victor.mvc.autoatendimento.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(columnDefinition="varchar(50)")
    private String authority;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

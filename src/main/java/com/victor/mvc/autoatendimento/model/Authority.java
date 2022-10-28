package com.victor.mvc.autoatendimento.model;



import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {
    @ManyToOne
    @Id
    @JoinColumn(name = "username",columnDefinition="varchar(50)")
    private User user;
    @Column(columnDefinition="varchar(50)")
    private String authority;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

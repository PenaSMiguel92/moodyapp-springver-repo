package com.moodyapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String pass;
    private String email;
    // @OneToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "ownerFK")
    // private UserInfo userinfo;
    // @OneToMany(fetch = FetchType.EAGER)
    // @JoinColumn(name = "ownerFK")
    // private List<Moodlet> moodlets;
}

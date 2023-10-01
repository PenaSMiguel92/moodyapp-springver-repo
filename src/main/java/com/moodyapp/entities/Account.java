package com.moodyapp.entities;

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


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<Moodlet> moodlets;
}

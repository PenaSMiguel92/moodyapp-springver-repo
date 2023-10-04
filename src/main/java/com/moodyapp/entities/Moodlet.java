package com.moodyapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Moodlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moodlet_id")
    private long moodlet_id;
    @Column(name = "moodlet_name")
    private String moodlet_name;
    @Column(name = "moodlet_value")
    private int moodlet_value;

    // public Moodlet(String name, Account owner) {
    //     this.moodlet_name = name;
    //     this.moodlet_value = 50;
    //     this.moodlet_owner = owner;
    // }

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "moodlet_owner")
    // private Account moodlet_owner; 
}

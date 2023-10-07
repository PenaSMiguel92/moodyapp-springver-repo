package com.moodyapp.entities;

import com.moodyapp.entities.Moodlet;
import java.util.List;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String pass;
    private String email;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountFK")
    private Profile profile;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountFK")
    private List<Moodlet> moodlets;
    // public void generateMoodlets() {
    //     List<String> moodletList = Arrays.asList("Hunger", "Fun",
    //             "Hygiene", "Bathroom", "Social",
    //             "Energy", "Environment");
    //     moodlets = moodletList.stream().map(e -> {
    //         Moodlet moodlet = new Moodlet(e, 50);
    //         moodlet.setMoodlet_owner(this);
    //         return moodlet;}).toList();
    // }
}

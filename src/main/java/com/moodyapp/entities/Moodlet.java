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

    public Moodlet(String name, int value) {
        this.moodlet_name = name;
        this.moodlet_value = value;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "accountFK")
    private Account moodlet_owner; 
}

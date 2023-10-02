package com.moodyapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
@Table(name = "moodlets")
public class Moodlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moodlet_id")
    private long moodlet_id;
    @Column(name = "moodlet_name")
    private String moodlet_name;
    @Column(name = "moodlet_value")
    private int moodlet_value;

    // @ManyToOne(fetch = FetchType.EAGER)
    // @JoinColumn(name = "moodlet_ownerId")
    // private Account moodlet_ownerId; 

    public Moodlet(String name, int value) {
        this.moodlet_name = name;
        this.moodlet_value = value;
    }
}

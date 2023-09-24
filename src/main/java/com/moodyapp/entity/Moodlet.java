package com.moodyapp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Data
public class Moodlet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerFK")
    private Account owner; 

    public Moodlet(String name, int value) {
        this.name = name;
        this.value = value;
    }
}

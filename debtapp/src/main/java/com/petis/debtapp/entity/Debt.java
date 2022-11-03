package com.petis.debtapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEBT")
public class Debt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int amount;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}

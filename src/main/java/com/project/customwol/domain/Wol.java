package com.project.customwol.domain;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Wol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mac;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

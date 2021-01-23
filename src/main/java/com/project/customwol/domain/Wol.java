package com.project.customwol.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Wol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mac;
    private String description;
}

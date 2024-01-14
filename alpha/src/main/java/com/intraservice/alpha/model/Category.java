package com.intraservice.alpha.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "category")
@Getter
@With
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="city_unit_id")
    @JsonBackReference
    private CityUnit cityUnit;
}

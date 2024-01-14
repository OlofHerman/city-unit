package com.intraservice.alpha.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "city_unit")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class CityUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "visitors")
    private int visitors;

    @OneToMany(mappedBy = "cityUnit", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Category> categories;
}

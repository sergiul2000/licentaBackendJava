package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "fixtures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fixtures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer match_id;
    @Column
    private String home_team;
    @Column
    private String away_team;
    @Column
    private Integer home_goals;
    @Column
    private Integer away_goals;
    @Column
    private Date datetime;
}

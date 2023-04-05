package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rosters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rosters {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private PlayerStatsEmbeddedId id;
}

package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "league")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String league_name;
}

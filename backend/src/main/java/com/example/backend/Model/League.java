package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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


//    @OneToMany(mappedBy = "leagueName", cascade = CascadeType.ALL)
//    private List<LeagueTable> leagueTables;
}

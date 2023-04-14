package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

//    public League(String league_name) {
//        this.league_name = league_name;
//    }

//    @ElementCollection
////    @OneToMany(targetEntity = LeagueTable.class,mappedBy = "league_name", cascade = CascadeType.ALL)
//    private List<LeagueTableEmbeddedId> leagueTables=new ArrayList<>();
}

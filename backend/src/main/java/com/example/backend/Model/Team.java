package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String team_name;

//    @ElementCollection
////    @OneToMany(targetEntity = LeagueTable.class,mappedBy = "league_name", cascade = CascadeType.ALL)
//    private List<LeagueTableEmbeddedId> leagueTables=new ArrayList<>();

//    @OneToMany(targetEntity = LeagueTable.class,mappedBy = "team_name", cascade = CascadeType.ALL)
//    private List<LeagueTable> leagueTables=new ArrayList<>();

//    public Team(String team_name) {
////        this.team_name = team_name;
////    }
//    @OneToMany(targetEntity = RostersEmbeddedId.class,mappedBy = "team_name", cascade = CascadeType.ALL)
//    private List<Rosters> rosters=new ArrayList<>();

//    public Team(String team_name) {
//        this.team_name = team_name;
//    }
}

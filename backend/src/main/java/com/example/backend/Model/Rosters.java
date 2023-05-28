package com.example.backend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
//    @EmbeddedId
//    private RostersEmbeddedId rosters_id;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_roster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_name", nullable = false,referencedColumnName = "league_name")
    private League league_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
//    @MapsId("team_name")
    private Team team_name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false,referencedColumnName = "player_id")
//    @MapsId("player_id")
    private Player player_id;
    private Integer year_start;
    private Integer year_end;


    @JsonProperty("team_name")
    public String getTeam() {
        return team_name.getTeam_name();
    }
    public void setTeam_name(String teamName) {
        Team team = new Team(teamName);
        this.team_name = team;
    }

    @JsonProperty("league_name")
    String getLeague() {
        return league_name.getLeague_name();
    }
    public void setLeague_name(String leagueName) {
        League league = new League(leagueName);
        this.league_name = league;
    }

    public Integer getPlayer_id() {
        return player_id.getPlayer_id();
    }

    public void setPlayer_id(Integer id_player) {
        Player player = new Player(id_player);
        this.player_id = player;
    }

//    @OneToOne(mappedBy = "rostersFK", cascade = CascadeType.ALL)
//    private PlayerDefensiveStats playerDefensiveStats;

    public Rosters(Integer id_roster,String league_name, String team_name, Integer player_id, Integer year_start, Integer year_end) {
        this.id_roster = id_roster;
        League league = new League(league_name);
        this.league_name = league;
        Team team = new Team(team_name);
        this.team_name = team;
        Player player = new Player(player_id);
        this.player_id = player;
        this.year_start = year_start;
        this.year_end = year_end;
    }

    public Rosters(Integer id_roster, String team_name, Integer player_id, Integer year_start, Integer year_end) {
        this.id_roster = id_roster;
        Team team = new Team(team_name);
        this.team_name = team;
        Player player = new Player(player_id);
        this.player_id = player;
        this.year_start = year_start;
        this.year_end = year_end;
    }

    public Rosters(Integer id_roster) {
        this.id_roster = id_roster;
    }

    //    @Override
//    public String toString() {
//        return "Rosters{" +
//                "id_roster=" + id_roster +
//                ", team_name=" + team_name.getTeam_name() +
//                ", player_id=" + player_id.getPlayer_id() +
//                ", year_start=" + year_start +
//                ", year_end=" + year_end +
//                '}';
//    }
}

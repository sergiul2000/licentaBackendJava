package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_defensive_stats")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class PlayerDefensiveStats {
    @Id
//    @Column(name = "defensive_id")
//    @GeneratedValue
    private Integer defensive_id;
    @Column
    private String player_name;
    @Column
    private double clearances_per_game;
    @Column
    private double dribbled_past_per_game;
    @Column
    private double fouls_per_game;
    @Column
    private Integer id_player;
    @Column
    private double interceptions_per_game;
    @Column
    private double offsides_won_per_game;
    @Column
    private double outfielder_blocks_per_game;
    @Column
    private Integer own_goals;
    @Column
    private double tackles_per_game;

    @Column
    private String   team_name;
    @Column
    private Integer year_start;
    @Column
    private Integer year_end;


//    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_roster")
//    @PrimaryKeyJoinColumn
//    @MapsId
    private Rosters id_roster;


    public Integer getId_roster() {
        return id_roster.getId_roster();
    }

    public void setId_roster(Integer rostersFK) {
        Rosters rosters = new Rosters(rostersFK);
        this.id_roster = rosters;
    }

//    public PlayerDefensiveStats(Integer defensiveId, String team_name, Integer id_player, Integer year_start, Integer year_end, double tacklesPerGame, double interceptions_per_game, double fouls_per_game, double offsides_won_per_game, double clearances_per_game, double dribbled_past_per_game, double outfielder_blocks_per_game, Integer own_goals, Integer rostersFKParam) {
//        this.defensive_id = defensiveId;
//        this.team_name = team_name;
//        this.id_player = id_player;
//        this.year_start = year_start;
//        this.year_end = year_end;
//        this.tackles_per_game = tacklesPerGame;
//        this.interceptions_per_game = interceptions_per_game;
//        this.fouls_per_game = fouls_per_game;
//        this.offsides_won_per_game = offsides_won_per_game;
//        this.clearances_per_game = clearances_per_game;
//        this.dribbled_past_per_game = dribbled_past_per_game;
//        this.outfielder_blocks_per_game = outfielder_blocks_per_game;
//        this.own_goals = own_goals;
//        Rosters rosters = new Rosters(rostersFKParam);
////        this.id_roster.setId_roster(rosters);
//        this.id_roster = rosters;
//    }


    public PlayerDefensiveStats(Integer defensive_id, String player_name,double clearances_per_game, double dribbled_past_per_game, double fouls_per_game, Integer id_player, double interceptions_per_game, double offsides_won_per_game, double outfielder_blocks_per_game, Integer own_goals, double tackles_per_game, String team_name, Integer year_end, Integer year_start, Integer id_roster) {
        this.defensive_id = defensive_id;
        this.player_name = player_name;
        this.clearances_per_game = clearances_per_game;
        this.dribbled_past_per_game = dribbled_past_per_game;
        this.fouls_per_game = fouls_per_game;
        this.id_player = id_player;
        this.interceptions_per_game = interceptions_per_game;
        this.offsides_won_per_game = offsides_won_per_game;
        this.outfielder_blocks_per_game = outfielder_blocks_per_game;
        this.own_goals = own_goals;
        this.tackles_per_game = tackles_per_game;
        this.team_name = team_name;
        this.year_start = year_start;
        this.year_end = year_end;
        Rosters rosters = new Rosters(id_roster,team_name,id_player,year_start,year_end);
//        this.id_roster.setId_roster(rosters);
        this.id_roster=rosters;
    }

    @Override
    public String toString() {
        return "PlayerDefensiveStats{" +
                "defensiveId=" + defensive_id +
                "player_name=" + player_name +
                ", team_name='" + team_name + '\'' +
                ", id_player=" + id_player +
                ", year_start=" + year_start +
                ", year_end=" + year_end +
                ", tacklesPerGame=" + tackles_per_game +
                ", interceptions_per_game=" + interceptions_per_game +
                ", fouls_per_game=" + fouls_per_game +
                ", offsides_won_per_game=" + offsides_won_per_game +
                ", clearances_per_game=" + clearances_per_game +
                ", dribbled_past_per_game=" + dribbled_past_per_game +
                ", outfielder_blocks_per_game=" + outfielder_blocks_per_game +
                ", own_goals=" + own_goals +
                ", rostersFK=" + id_roster+//.getId_roster() +
                '}';
    }
}

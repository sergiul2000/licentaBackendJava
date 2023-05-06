package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_passing_stats")
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class PlayerPassingStats {
    @Id
//    @Column(name = "defensive_id")
//    @GeneratedValue
    private Integer passing_id;
    @Column
    private String player_name;
    @Column
    private String team_name;
    @Column
    private Integer id_player;
    @Column
    private Integer year_start;
    @Column
    private Integer year_end;
    @Column
    private double key_passes_per_game;
    @Column
    private double passes_per_game;
    @Column
    private double crosses_per_game;
    @Column
    private double long_ball_per_game;
    @Column
    private double through_balls_per_game;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_roster")
    private Rosters id_roster;


    public Integer getId_roster() {
        return id_roster.getId_roster();
    }

    public void setId_roster(Integer rostersFK) {
        Rosters rosters = new Rosters(rostersFK);
        this.id_roster = rosters;
    }

    public PlayerPassingStats(Integer passing_id, String player_name, String team_name, Integer id_player, Integer year_start, Integer year_end, double key_passes_per_game, double passes_per_game, double crosses_per_game, double long_ball_per_game, double through_balls_per_game, Integer id_roster) {
        this.passing_id = passing_id;
        this.player_name = player_name;
        this.team_name = team_name;
        this.id_player = id_player;
        this.year_start = year_start;
        this.year_end = year_end;
        this.key_passes_per_game = key_passes_per_game;
        this.passes_per_game = passes_per_game;
        this.crosses_per_game = crosses_per_game;
        this.long_ball_per_game = long_ball_per_game;
        this.through_balls_per_game = through_balls_per_game;
        Rosters rosters = new Rosters(id_roster);
        this.id_roster = rosters;
    }

    @Override
    public String toString() {
        return "PlayerPassingStats{" +
                "offensive_id=" + passing_id +
                ", player_name='" + player_name + '\'' +
                ", team_name='" + team_name + '\'' +
                ", id_player=" + id_player +
                ", year_start=" + year_start +
                ", year_end=" + year_end +
                ", key_passes_per_game=" + key_passes_per_game +
                ", passes_per_game=" + passes_per_game +
                ", crosses_per_game=" + crosses_per_game +
                ", long_ball_per_game=" + long_ball_per_game +
                ", through_balls_per_game=" + through_balls_per_game +
                ", id_roster=" + id_roster +
                '}';
    }
}

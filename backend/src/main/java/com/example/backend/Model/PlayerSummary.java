package com.example.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "player_summary")
@Getter
@Setter
@NoArgsConstructor
public class PlayerSummary {
    @Id
    private Integer summary_id;
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
    private String games;
    @Column
    private Integer start_games;
    @Column
    private Integer sub_games;
    @Column
    private double mins;
    @Column
    private Integer goals;
    @Column
    private Integer assists;
    @Column
    private Integer yellow_cards;
    @Column
    private Integer red_cards;
    @Column
    private double shots_per_game;
    @Column
    private double pass_success_percentage;
    @Column
    private Integer aerials_won;
    @Column
    private Integer man_of_the_match;
    @Column
    private double rating;


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

    public PlayerSummary(Integer summary_id, String player_name, String team_name, Integer id_player, Integer year_start, Integer year_end, String games, Integer start_games, Integer sub_games, double mins, Integer goals, Integer assists, Integer yellow_cards, Integer red_cards, double shots_per_game, double pass_success_percentage, Integer aerials_won, Integer man_of_the_match, double rating, Integer id_roster) {
        this.summary_id = summary_id;
        this.player_name = player_name;
        this.team_name = team_name;
        this.id_player = id_player;
        this.year_start = year_start;
        this.year_end = year_end;
        this.games = games;
        this.start_games = start_games;
        this.sub_games = sub_games;
        this.mins = mins;
        this.goals = goals;
        this.assists = assists;
        this.yellow_cards = yellow_cards;
        this.red_cards = red_cards;
        this.shots_per_game = shots_per_game;
        this.pass_success_percentage = pass_success_percentage;
        this.aerials_won = aerials_won;
        this.man_of_the_match = man_of_the_match;
        this.rating = rating;
        Rosters rosters = new Rosters(id_roster);
        this.id_roster = rosters;
    }


    @Override
    public String toString() {
        return "PlayerSummary{" +
                "summary_id=" + summary_id +
                ", player_name='" + player_name + '\'' +
                ", team_name='" + team_name + '\'' +
                ", id_player=" + id_player +
                ", year_start=" + year_start +
                ", year_end=" + year_end +
                ", games='" + games + '\'' +
                ", start_games=" + start_games +
                ", sub_games=" + sub_games +
                ", mins=" + mins +
                ", goals=" + goals +
                ", assists=" + assists +
                ", yellow_cards=" + yellow_cards +
                ", red_cards=" + red_cards +
                ", shots_per_game=" + shots_per_game +
                ", pass_success_percentage=" + pass_success_percentage +
                ", aerials_won=" + aerials_won +
                ", man_of_the_match=" + man_of_the_match +
                ", rating=" + rating +
                ", id_roster=" + id_roster +
                '}';
    }
}

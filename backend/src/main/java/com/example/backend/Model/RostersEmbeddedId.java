//package com.example.backend.Model;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.MapsId;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.io.Serializable;
//
////@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class RostersEmbeddedId implements Serializable {
//
//
////    private String team_name;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_name", nullable = false,referencedColumnName = "team_name")
//    @MapsId("team_name")
//    private Team team_name;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "player_id", nullable = false,referencedColumnName = "player_id")
//    @MapsId("player_id")
//    private Player id_player;
//    private Integer year_start;
//    private Integer year_end;
//
//
//
//
//    String getTeam_name() {
//        return team_name.getTeam_name();
//    }
//    public void setTeam_name(String teamName) {
//        Team team = new Team(teamName);
//        this.team_name = team;
//    }
//    @JsonProperty("team_name")
//    public String getTeam() {
//        return team_name.getTeam_name();
//    }
//
//    public Integer getId_player() {
//        return id_player.getPlayer_id();
//    }
//
//    public void setId_player(Integer id_player) {
//        Player player = new Player(id_player);
//        this.id_player = player;
//    }
//
//    public RostersEmbeddedId(String team_name, Integer id_player, Integer year_start, Integer year_end) {
//        Team team = new Team(team_name);
//        this.team_name = team;
//        Player player = new Player(id_player);
//        this.id_player = player;
//        this.year_start = year_start;
//        this.year_end = year_end;
//    }
//
//
//}

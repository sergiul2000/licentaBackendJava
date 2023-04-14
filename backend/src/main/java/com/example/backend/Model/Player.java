package com.example.backend.Model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "player")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer player_id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String position;
    @Column()
    private Integer height;
    @Column()
    private Integer weight;

    public Player(Integer player_id) {
        this.player_id = player_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getPlayer_id().equals(player.getPlayer_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayer_id());
    }

//    @ElementCollection
////    @OneToMany(targetEntity = LeagueTable.class,mappedBy = "league_name", cascade = CascadeType.ALL)
//    private List<RostersEmbeddedId> rosters=new ArrayList<>();
}

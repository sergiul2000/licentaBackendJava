package com.example.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerStatsEmbeddedId implements Serializable {
    private String team_name;
    private Integer id_player;
    private Integer year_start;
    private Integer year_end;

}

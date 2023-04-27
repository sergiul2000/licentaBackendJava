package com.example.backend.Controllers;


import com.example.backend.Model.PlayerDefensiveStats;
import com.example.backend.Model.PlayerOffensiveStats;
import com.example.backend.Services.PlayerOffensiveStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/football-analytics/playerOffensive")
public class PlayerOffensiveStatsController {
    @Autowired
    private PlayerOffensiveStatsService playerOffensiveStatsService;

    @GetMapping(value = "")
    public List<PlayerOffensiveStats> getAllPlayerOffensive() {
        return playerOffensiveStatsService.getAllPlayersOffensiveStats();
    }

    @PostMapping
    public PlayerOffensiveStats savePlayerOffensive(@RequestBody PlayerOffensiveStats playerOffensiveStats) {
        return playerOffensiveStatsService.savePlayerOffensive(playerOffensiveStats);
    }

    @GetMapping(value = "{id}")
    public Optional<PlayerOffensiveStats> getById(@PathVariable Integer id) {
        return playerOffensiveStatsService.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public boolean deleteById(@PathVariable Integer id){
        return playerOffensiveStatsService.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public PlayerOffensiveStats update(@PathVariable Integer id,@RequestBody PlayerOffensiveStats playerOffensiveStats){
        Optional<PlayerOffensiveStats> existingObject = playerOffensiveStatsService.getById(id);
        if(existingObject.isEmpty()){
            return null;
        }
        PlayerOffensiveStats modifiedObject = existingObject.get();
        playerOffensiveStatsService.deleteById(id);
        return playerOffensiveStatsService.savePlayerOffensive(playerOffensiveStats);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{team_name}/{year_start}")
    public List<PlayerOffensiveStats> getAllPlayerOffensiveByTeamAndYearStart(@PathVariable String team_name,
                                                                              @PathVariable Integer year_start) {
        return playerOffensiveStatsService.getPlayersDefensiveStatsByTeamAndYearStart(team_name,year_start);
    }
}

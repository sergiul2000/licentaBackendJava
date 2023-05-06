package com.example.backend.Controllers;

import com.example.backend.Model.PlayerPassingStats;
import com.example.backend.Services.PLayerPassingStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/playerPassing")
public class PlayerPassingStatsController {
    @Autowired
    private PLayerPassingStatsService playerPassingStatsService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<PlayerPassingStats> getAllPlayerPassingStats() {
        return playerPassingStatsService.getAllPlayerPassingStats();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public PlayerPassingStats savePlayerPassingStats(@RequestBody PlayerPassingStats playerPassingStats) {
        return playerPassingStatsService.savePlayerPassing(playerPassingStats);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "{id}")
    public Optional<PlayerPassingStats> getById(@PathVariable Integer id) {
        return playerPassingStatsService.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "{id}")
    public boolean deleteById(@PathVariable Integer id){
        return playerPassingStatsService.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "{id}")
    public PlayerPassingStats update(@PathVariable Integer id,@RequestBody PlayerPassingStats playerPassingStats){
        Optional<PlayerPassingStats> existingObject = playerPassingStatsService.getById(id);
        if(existingObject.isEmpty()){
            return null;
        }
        PlayerPassingStats modifiedObject = existingObject.get();
        playerPassingStatsService.deleteById(id);
        return playerPassingStatsService.savePlayerPassing(playerPassingStats);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{team_name}/{year_start}")
    public List<PlayerPassingStats> getAllPlayerPassingStatsByTeamAndYearStart(@PathVariable String team_name,
                                                                              @PathVariable Integer year_start) {
        return playerPassingStatsService.getPlayerPassingStatsByTeamAndYearStart(team_name,year_start);
    }

}

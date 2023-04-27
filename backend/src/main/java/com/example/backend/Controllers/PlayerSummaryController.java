package com.example.backend.Controllers;

import com.example.backend.Model.PlayerOffensiveStats;
import com.example.backend.Model.PlayerSummary;
import com.example.backend.Services.PlayerSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/playerSummary")
public class PlayerSummaryController {
    @Autowired
    private PlayerSummaryService playerSummaryService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<PlayerSummary> getAllPlayerSummary() {
        return playerSummaryService.getAllPlayersSummary();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public PlayerSummary savePlayerSummary(@RequestBody PlayerSummary playerSummary) {
        return playerSummaryService.savePlayerSummary(playerSummary);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "{id}")
    public Optional<PlayerSummary> getById(@PathVariable Integer id) {
        return playerSummaryService.getById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "{id}")
    public boolean deleteById(@PathVariable Integer id){
        return playerSummaryService.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "{id}")
    public PlayerSummary update(@PathVariable Integer id,@RequestBody PlayerSummary playerSummary){
        Optional<PlayerSummary> existingObject = playerSummaryService.getById(id);
        if(existingObject.isEmpty()){
            return null;
        }
        PlayerSummary modifiedObject = existingObject.get();
        playerSummaryService.deleteById(id);
        return playerSummaryService.savePlayerSummary(playerSummary);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{team_name}/{year_start}")
    public List<PlayerSummary> getAllPlayerSummaryByTeamAndYearStart(@PathVariable String team_name,
                                                                              @PathVariable Integer year_start) {
        return playerSummaryService.getPlayersSummaryByTeamAndYearStart(team_name,year_start);
    }

}

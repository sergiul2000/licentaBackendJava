package com.example.backend.Controllers;

import com.example.backend.Model.PlayerDefensiveStats;
import com.example.backend.Model.Rosters;
import com.example.backend.Services.PlayerDefensiveStatsService;
import com.example.backend.Services.RostersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/playerDefensive")
public class PlayerDefensiveStatsController {
    @Autowired
    private PlayerDefensiveStatsService playerDefensiveStatsService;

//    @Autowired
//    private RostersService rostersService;

//    @CrossOrigin(origins = "http://localhost/football-analytics/playerDefensive:3000")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<PlayerDefensiveStats> getAllPlayerDefensive() {
        return playerDefensiveStatsService.getAllPlayersDefensiveStats();
    }

    @PostMapping
    public PlayerDefensiveStats savePlayerDefensive(@RequestBody PlayerDefensiveStats playerDefensiveStats) {
//        Integer idRoster = rostersService.getRostersIdByAllFields(playerDefensiveStats.getTeam_name(), playerDefensiveStats.getId_player(),
//                playerDefensiveStats.getYear_start(),playerDefensiveStats.getYear_end());
////        System.out.println(rosters.getId_roster().getClass()+" "+rosters.getTeam().getClass()+" "+rosters.getPlayer_id().getClass()+" ");
//        playerDefensiveStats.setRostersFK(idRoster);
//        System.out.println(playerDefensiveStats.getDefensiveId()+" "+ playerDefensiveStats.getOwn_goals()+" "
//        +playerDefensiveStats.getDribbled_past_per_game());
//        System.out.println(playerDefensiveStats.toString());
        return playerDefensiveStatsService.savePlayerDefensive(playerDefensiveStats);
    }

    @GetMapping(value = "{id}")
    public Optional<PlayerDefensiveStats> getById(@PathVariable Integer id) {
        return playerDefensiveStatsService.getById(id);
    }

    @DeleteMapping(value = "{id}")
    public boolean deleteById(@PathVariable Integer id){
        return playerDefensiveStatsService.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public PlayerDefensiveStats update(@PathVariable Integer id,@RequestBody PlayerDefensiveStats playerDefensiveStats){
        Optional<PlayerDefensiveStats> existingObject = playerDefensiveStatsService.getById(id);
        if(existingObject.isEmpty()){
            return null;
        }
        PlayerDefensiveStats modifiedObject = existingObject.get();
        playerDefensiveStatsService.deleteById(id);
        return playerDefensiveStatsService.savePlayerDefensive(playerDefensiveStats);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{team_name}/{year_start}")
    public List<PlayerDefensiveStats> getAllPlayerDefensiveByTeamAndYearStart(@PathVariable String team_name,
                                                                              @PathVariable Integer year_start) {
        return playerDefensiveStatsService.getPlayersDefensiveStatsByTeamAndYearStart(team_name,year_start);
    }

}

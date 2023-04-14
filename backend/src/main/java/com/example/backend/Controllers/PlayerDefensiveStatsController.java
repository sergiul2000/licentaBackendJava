package com.example.backend.Controllers;

import com.example.backend.Model.PlayerDefensiveStats;
import com.example.backend.Model.Rosters;
import com.example.backend.Services.PlayerDefensiveStatsService;
import com.example.backend.Services.RostersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/football-analytics/playerDefensive")
public class PlayerDefensiveStatsController {
    @Autowired
    private PlayerDefensiveStatsService playerDefensiveStatsService;

//    @Autowired
//    private RostersService rostersService;

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
}
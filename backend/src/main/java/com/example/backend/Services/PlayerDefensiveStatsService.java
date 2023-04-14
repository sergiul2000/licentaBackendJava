package com.example.backend.Services;

import com.example.backend.Model.Player;
import com.example.backend.Model.PlayerDefensiveStats;
import com.example.backend.Repositories.PlayerDefensiveStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerDefensiveStatsService {
    @Autowired
    private PlayerDefensiveStatsRepo playerDefensiveStatsRepo;


    public List<PlayerDefensiveStats> getAllPlayersDefensiveStats() {
        return playerDefensiveStatsRepo.findAll();
    }

//    public PlayerDefensiveStats getPlayersDefensiveStatsById(Integer id) {
//        return playerDefensiveStatsRepo.findAll();
//    }
public PlayerDefensiveStats savePlayerDefensive(PlayerDefensiveStats player) {
     if(playerDefensiveStatsRepo.existsById(player.getDefensive_id()))
        return null;
    return playerDefensiveStatsRepo.save(player);
}

}

package com.example.backend.Services;

import com.example.backend.Model.PlayerDefensiveStats;
import com.example.backend.Model.PlayerOffensiveStats;
import com.example.backend.Repositories.PlayerDefensiveStatsRepo;
import com.example.backend.Repositories.PlayerOffensiveStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerOffensiveStatsService {
    @Autowired
    private PlayerOffensiveStatsRepo playerOffensiveStatsRepo;


    public List<PlayerOffensiveStats> getAllPlayersOffensiveStats() {
        return playerOffensiveStatsRepo.findAll();
    }


    public PlayerOffensiveStats savePlayerOffensive(PlayerOffensiveStats player) {
        if(playerOffensiveStatsRepo.existsById(player.getOffensive_id()))
            return null;
        return playerOffensiveStatsRepo.save(player);
    }

    public Optional<PlayerOffensiveStats> getById(Integer id){
        return playerOffensiveStatsRepo.findById(id);
    }

    public boolean deleteById(Integer id){
        if(playerOffensiveStatsRepo.existsById(id)){
            playerOffensiveStatsRepo.deleteById(id);
            return true;
        }
        return false;
    }
}

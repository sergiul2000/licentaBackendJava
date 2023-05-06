package com.example.backend.Services;

import com.example.backend.Model.PlayerPassingStats;
import com.example.backend.Repositories.PlayerPassingStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PLayerPassingStatsService {
    @Autowired
    private PlayerPassingStatsRepo playerPassingStatsRepo;


    public List<PlayerPassingStats> getAllPlayerPassingStats() {
        return playerPassingStatsRepo.findAll();
    }


    public PlayerPassingStats savePlayerPassing(PlayerPassingStats player) {
        if(playerPassingStatsRepo.existsById(player.getPassing_id()))
            return null;
        return playerPassingStatsRepo.save(player);
    }

    public Optional<PlayerPassingStats> getById(Integer id){
        return playerPassingStatsRepo.findById(id);
    }

    public boolean deleteById(Integer id){
        if(playerPassingStatsRepo.existsById(id)){
            playerPassingStatsRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<PlayerPassingStats> getPlayerPassingStatsByTeamAndYearStart(String teamName,Integer yearStart) {
        List<PlayerPassingStats> response = new ArrayList<>();
        List<PlayerPassingStats> allPlayers =  playerPassingStatsRepo.findAll();
        for(PlayerPassingStats iterator : allPlayers){
            if(iterator.getTeam_name().equals(teamName) && (iterator.getYear_start().intValue() == yearStart.intValue())){

//                System.out.println(iterator.getTeam_name()+" "+(iterator.getYear_start() == yearStart));
                response.add(iterator);
            }
        }
        return response;
    }
}

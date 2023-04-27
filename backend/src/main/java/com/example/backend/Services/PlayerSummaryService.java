package com.example.backend.Services;

import com.example.backend.Model.PlayerSummary;
import com.example.backend.Repositories.PlayerSummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerSummaryService {
    @Autowired
    private PlayerSummaryRepo playerSummaryRepo;


    public List<PlayerSummary> getAllPlayersSummary() {
        return playerSummaryRepo.findAll();
    }


    public PlayerSummary savePlayerSummary(PlayerSummary player) {
        if(playerSummaryRepo.existsById(player.getSummary_id()))
            return null;
        return playerSummaryRepo.save(player);
    }

    public Optional<PlayerSummary> getById(Integer id){
        return playerSummaryRepo.findById(id);
    }

    public boolean deleteById(Integer id){
        if(playerSummaryRepo.existsById(id)){
            playerSummaryRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<PlayerSummary> getPlayersSummaryByTeamAndYearStart(String teamName,Integer yearStart) {
        List<PlayerSummary> response = new ArrayList<>();
        List<PlayerSummary> allPlayers =  playerSummaryRepo.findAll();
        for(PlayerSummary iterator : allPlayers){
            if(iterator.getTeam_name().equals(teamName) && (iterator.getYear_start().intValue() == yearStart.intValue())){

//                System.out.println(iterator.getTeam_name()+" "+(iterator.getYear_start() == yearStart));
                response.add(iterator);
            }
        }
        return response;
    }
}

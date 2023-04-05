package com.example.backend.Services;

import com.example.backend.Model.League;
import com.example.backend.Model.Player;
import com.example.backend.Repositories.LeagueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    @Autowired
    private LeagueRepo leagueRepo;

    public List<League> getAllLeagues() {
        return leagueRepo.findAll();
    }

    public Optional<League> getLeagueByName(String name) {
        return leagueRepo.findById(name);
    }

    public League saveLeague(League league) {
        if(leagueRepo.existsById(league.getLeague_name()))
            return null;
        return leagueRepo.save(league);
    }

    public void deleteLeague(String name) {
        leagueRepo.deleteById(name);
    }
}

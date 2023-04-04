package com.example.backend.Services;

import com.example.backend.Model.LeagueTable;
import com.example.backend.Model.Player;
import com.example.backend.Repositories.LeagueTableRepo;
import com.example.backend.Repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueTableService {
    @Autowired
    private LeagueTableRepo leagueTableRepo;

    public List<LeagueTable> getAllLeagueTables() {
        return leagueTableRepo.findAll();
    }

    public Optional<LeagueTable> getLeagueTableById(String teamName,Integer yearStart, Integer yearEnd) {
        return leagueTableRepo.findById(teamName,yearStart,yearEnd);
    }

    public LeagueTable saveLeagueTable(LeagueTable leagueTable) {
        return leagueTableRepo.save(leagueTable);
    }

    public void deleteLeagueTable(String teamName,Integer yearStart,Integer yearEnd) {
        leagueTableRepo.deleteByAllId(teamName,yearStart,yearEnd);
    }
}

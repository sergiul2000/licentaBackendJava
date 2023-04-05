package com.example.backend.Services;

import com.example.backend.Model.League;
import com.example.backend.Model.LeagueTable;
import com.example.backend.Model.LeagueTableEmbeddedId;
import com.example.backend.Repositories.LeagueRepo;
import com.example.backend.Repositories.LeagueTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueTableService {
    @Autowired
    private LeagueTableRepo leagueTableRepo;
//    @Autowired
//    private LeagueRepo leagueRepo;

    public List<LeagueTable> getAllLeagueTables() {
        return leagueTableRepo.findAll();
    }

    public Optional<LeagueTable> getLeagueTableById(String teamName,Integer yearStart, Integer yearEnd) {
        LeagueTableEmbeddedId id = new LeagueTableEmbeddedId(teamName,yearStart,yearEnd);
        return leagueTableRepo.findById(id);
    }

    public LeagueTable saveLeagueTable(LeagueTable leagueTable) {
        if(leagueTableRepo.existsById(leagueTable.getId())){
            return null;
        }
        return leagueTableRepo.save(leagueTable);
    }

    public void deleteLeagueTable(String teamName,Integer yearStart,Integer yearEnd) {
        LeagueTableEmbeddedId id = new LeagueTableEmbeddedId(teamName,yearStart,yearEnd);
        leagueTableRepo.deleteById(id);
    }

//    public List<LeagueTable> getLeagueTableByLeagueName(String leagueName) throws ChangeSetPersister.NotFoundException {
//        League league = leagueRepo.findById(leagueName).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
//        if(league == null)
//            return null;
//        return leagueTableRepo.findByLeague(leagueName);
//    }
}

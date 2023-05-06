package com.example.backend.Services;

import com.example.backend.Model.League;
import com.example.backend.Model.LeagueTable;
import com.example.backend.Model.LeagueTableEmbeddedId;
import com.example.backend.Model.PlayerPassingStats;
import com.example.backend.Repositories.LeagueRepo;
import com.example.backend.Repositories.LeagueTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Optional<LeagueTable> getLeagueTableById(Integer id) {
        return leagueTableRepo.findById(id);
    }
    public List<LeagueTable> getLeagueTableByTeamAndYear(String teamName,Integer yearStart) {
        List<LeagueTable> response = new ArrayList<>();
        List<LeagueTable> allPlayers =  leagueTableRepo.findAll();
        for(LeagueTable iterator : allPlayers){
            if(iterator.getTeam_name().equals(teamName) && (iterator.getYear_start().intValue() == yearStart.intValue())){

//                System.out.println(iterator.getTeam_name()+" "+(iterator.getYear_start() == yearStart));
                response.add(iterator);
            }
        }
        return response;
    }

    public LeagueTable saveLeagueTable(LeagueTable leagueTable) {
        if(leagueTableRepo.existsById(leagueTable.getLeague_table_id())){
            return null;
        }
        return leagueTableRepo.save(leagueTable);
    }

    public void deleteLeagueTable(Integer id) {
//        LeagueTableEmbeddedId id = new LeagueTableEmbeddedId(teamName,yearStart,yearEnd);
        leagueTableRepo.deleteById(id);
    }

//    public List<LeagueTable> getLeagueTableByLeagueName(String leagueName) throws ChangeSetPersister.NotFoundException {
//        League league = leagueRepo.findById(leagueName).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
//        if(league == null)
//            return null;
//        return leagueTableRepo.findByLeague(leagueName);
//    }
}

package com.example.backend.Controllers;

import com.example.backend.Model.*;
import com.example.backend.Services.LeagueTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/leagueTable")
public class LeagueTableController {
    @Autowired
    private LeagueTableService leagueTableService;
    @GetMapping(value = "")
    public List<LeagueTable> getAllLeagueTables() throws IOException {
        return leagueTableService.getAllLeagueTables();
    }

    @GetMapping("/{teamName}/{yearStart}/{yearEnd}")
    public Optional<LeagueTable> getLeagueTableById(@PathVariable String teamName,
                                                    @PathVariable Integer yearStart,
                                                    @PathVariable Integer yearEnd) {
        return leagueTableService.getLeagueTableById(teamName,yearStart,yearEnd);
    }
    @PostMapping()
    public LeagueTable saveLeagueTable(@RequestBody LeagueTable leagueTable) {
        return leagueTableService.saveLeagueTable(leagueTable);
    }

    @PutMapping("/{teamName}/{yearStart}/{yearEnd}")
    public String updateLeagueTable(@PathVariable String teamName,
                                    @PathVariable Integer yearStart,
                                    @PathVariable Integer yearEnd,
                                    @RequestBody LeagueTable leagueTable) throws ChangeSetPersister.NotFoundException {
        Optional<LeagueTable> existingLeagueTable = leagueTableService.getLeagueTableById(teamName,yearStart,yearEnd);
        if(existingLeagueTable.isEmpty()) {
            return "Not found";
        }
        Optional<LeagueTable> leagueTableOptional = leagueTableService.getLeagueTableById(teamName,yearStart,yearEnd);
        LeagueTable optionalLeagueTable = leagueTableOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
//        optionalLeagueTable.setLeague_name(leagueTable.getLeague_name());
        optionalLeagueTable.setId(leagueTable.getId());
        optionalLeagueTable.setMatches(leagueTable.getMatches());
        optionalLeagueTable.setWins(leagueTable.getWins());
        optionalLeagueTable.setDraws(leagueTable.getDraws());
        optionalLeagueTable.setLoses(leagueTable.getLoses());
        optionalLeagueTable.setGoals(leagueTable.getGoals());
        optionalLeagueTable.setGoalsAgainst(leagueTable.getGoalsAgainst());
        optionalLeagueTable.setPts(leagueTable.getPts());
        optionalLeagueTable.setXGoals(leagueTable.getXGoals());
        optionalLeagueTable.setNpxGoals(leagueTable.getNpxGoals());
        optionalLeagueTable.setGoalsAgainst(leagueTable.getGoalsAgainst());
        optionalLeagueTable.setNpxGoalsAgainst(leagueTable.getNpxGoalsAgainst());
        optionalLeagueTable.setNpxGoalsDifference(leagueTable.getNpxGoalsDifference());
        optionalLeagueTable.setPpda(leagueTable.getPpda());
        optionalLeagueTable.setOppda(leagueTable.getOppda());
        optionalLeagueTable.setDc(leagueTable.getDc());
        optionalLeagueTable.setOdc(leagueTable.getOdc());
        leagueTableService.deleteLeagueTable(teamName,yearStart,yearEnd);
        leagueTableService.saveLeagueTable(optionalLeagueTable);
        return "Succesfully modified!";
    }
    @DeleteMapping("/{teamName}/{yearStart}/{yearEnd}")
    public boolean deleteLeagueTable(@PathVariable String teamName,
                                     @PathVariable Integer yearStart,
                                     @PathVariable Integer yearEnd) {
        leagueTableService.deleteLeagueTable(teamName,yearStart, yearEnd);
        return true;
    }
}

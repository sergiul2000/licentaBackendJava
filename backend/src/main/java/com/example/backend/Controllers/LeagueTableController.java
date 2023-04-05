package com.example.backend.Controllers;

import com.example.backend.Model.*;
import com.example.backend.Services.LeagueTableService;
import com.example.backend.Services.TeamService;
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
        optionalLeagueTable.setLeague_name(leagueTable.getLeague_name());
        optionalLeagueTable.setId(leagueTable.getId());
        optionalLeagueTable.setMatches(leagueTable.getMatches());
        optionalLeagueTable.setWins(leagueTable.getWins());
        optionalLeagueTable.setDraws(leagueTable.getDraws());
        optionalLeagueTable.setLoses(leagueTable.getLoses());
        optionalLeagueTable.setGoals(leagueTable.getGoals());
        optionalLeagueTable.setGoals_against(leagueTable.getGoals_against());
        optionalLeagueTable.setPoints(leagueTable.getPoints());
        optionalLeagueTable.setXgoals(leagueTable.getXgoals());
        optionalLeagueTable.setNpx_goals(leagueTable.getNpx_goals());
        optionalLeagueTable.setXassists(leagueTable.getXassists());
        optionalLeagueTable.setNpx_goals_against(leagueTable.getNpx_goals_against());
        optionalLeagueTable.setNpx_goals_difference(leagueTable.getNpx_goals_difference());
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

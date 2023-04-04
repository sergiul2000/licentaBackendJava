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
        if(existingLeagueTable == null) {
            return "Not found";
        }
        Optional<LeagueTable> leagueTableOptional = leagueTableService.getLeagueTableById(teamName,yearStart,yearEnd);
        LeagueTable optionalLeagueTable = leagueTableOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
//        optionalLeagueTable.setName(player.getName());
//        optionalPlayer.setAge(player.getAge());
//        optionalPlayer.setPosition(player.getPosition());
//        optionalPlayer.setHeight(player.getHeight());
//        optionalPlayer.setWeight(player.getWeight());
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

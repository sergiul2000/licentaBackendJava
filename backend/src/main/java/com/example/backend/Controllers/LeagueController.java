package com.example.backend.Controllers;

import com.example.backend.Model.League;
import com.example.backend.Model.Player;
import com.example.backend.Services.LeagueService;
import com.example.backend.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @GetMapping(value = "")
    public List<League> getAllLeagues() throws IOException {
        return leagueService.getAllLeagues();
    }

    @GetMapping("/{name}")
    public Optional<League> getLeagueByName(@PathVariable String name) {
        return leagueService.getLeagueByName(name);
    }

    @PostMapping()
    public League saveLeague(@RequestBody League league) {
        return leagueService.saveLeague(league);
    }
    @PutMapping("/{name}")
    public String updateLeague(@PathVariable(value = "name") String name, @RequestBody League league) throws ChangeSetPersister.NotFoundException {
        Optional<League> existingLeague = leagueService.getLeagueByName(name);
        if(existingLeague == null) {
            return "Not found";
        }
        Optional<League> leagueOptional = leagueService.getLeagueByName(name);
        League optionalLeague = leagueOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        optionalLeague.setLeague_name(league.getLeague_name());
        leagueService.deleteLeague(name);
        leagueService.saveLeague(optionalLeague);
        return "Succesfully modified!";
    }

    @DeleteMapping("/{name}")
    public boolean deleteUser(@PathVariable String name) {
        leagueService.deleteLeague(name);
        return true;
    }
}

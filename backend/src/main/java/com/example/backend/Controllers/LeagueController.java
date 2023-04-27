package com.example.backend.Controllers;

import com.example.backend.Model.League;
import com.example.backend.Services.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/league")
public class LeagueController {
    @Autowired
    private LeagueService leagueService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<League> getAllLeagues() throws IOException {
        return leagueService.getAllLeagues();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{name}")
    public Optional<League> getLeagueByName(@PathVariable String name) {
        return leagueService.getLeagueByName(name);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public League saveLeague(@RequestBody League league) {
        return leagueService.saveLeague(league);
    }

    @CrossOrigin(origins = "http://localhost:3000")
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

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{name}")
    public boolean deleteUser(@PathVariable String name) {
        return leagueService.deleteLeague(name);
//        return true;
    }
}

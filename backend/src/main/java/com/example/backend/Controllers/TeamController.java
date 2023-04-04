package com.example.backend.Controllers;

import com.example.backend.Model.League;
import com.example.backend.Model.Team;
import com.example.backend.Services.LeagueService;
import com.example.backend.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/football-analytics/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping(value = "")
    public List<Team> getAllLeagues() throws IOException {
        return teamService.getAllTeams();
    }

    @GetMapping("/{name}")
    public Optional<Team> getLeagueByName(@PathVariable String name) {
        return teamService.getTeamByName(name);
    }

    @PostMapping()
    public Team saveLeague(@RequestBody Team team) {
        return teamService.saveTeam(team);
    }
    @PutMapping("/{name}")
    public String updateLeague(@PathVariable(value = "name") String name, @RequestBody Team team) throws ChangeSetPersister.NotFoundException {
        Optional<Team> existingTeam = teamService.getTeamByName(name);
        if(existingTeam == null) {
            return "Not found";
        }
        Optional<Team> teamOptional = teamService.getTeamByName(name);
        Team optionalTeam = teamOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        optionalTeam.setTeam_name(team.getTeam_name());
        teamService.saveTeam(optionalTeam);
        return "Succesfully modified!";
    }

    @DeleteMapping("/{name}")
    public boolean deleteUser(@PathVariable String name) {
        teamService.deleteTeam(name);
        return true;
    }
}

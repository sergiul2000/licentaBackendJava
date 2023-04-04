package com.example.backend.Services;

import com.example.backend.Model.League;
import com.example.backend.Model.Team;
import com.example.backend.Repositories.LeagueRepo;
import com.example.backend.Repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeamService {

    @Autowired
    private TeamRepo teamRepo;

    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    public Optional<Team> getTeamByName(String name) {
        return teamRepo.findById(name);
    }

    public Team saveTeam(Team team) {
        return teamRepo.save(team);
    }

    public void deleteTeam(String name) {
        teamRepo.deleteById(name);
    }
}

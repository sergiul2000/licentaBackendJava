package com.example.backend.Services;

import com.example.backend.Model.Team;
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
        if(teamRepo.existsById(team.getTeam_name()))
            return null;
        return teamRepo.save(team);
    }

    public boolean deleteTeam(String name) {
        if(teamRepo.existsById(name)){
            teamRepo.deleteById(name);
            return true;
        }
        return false;
    }
}

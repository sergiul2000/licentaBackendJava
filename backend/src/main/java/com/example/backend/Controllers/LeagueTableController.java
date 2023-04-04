package com.example.backend.Controllers;

import com.example.backend.Model.LeagueTable;
import com.example.backend.Model.Team;
import com.example.backend.Services.LeagueTableService;
import com.example.backend.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/football-analytics/leagueTable")
public class LeagueTableController {
    @Autowired
    private LeagueTableService leagueTableService;
    @GetMapping(value = "")
    public List<LeagueTable> getAllLeagueTables() throws IOException {
        return leagueTableService.getAllLeagueTables();
    }

}

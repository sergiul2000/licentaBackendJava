package com.example.backend.Controllers;

import com.example.backend.Model.Player;
import com.example.backend.Model.Rosters;
import com.example.backend.Services.RostersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/rosters")

public class RostersController {
    @Autowired
    private RostersService rostersService;

    @GetMapping(value = "")
    public List<Rosters> getAllRosters() {
        return rostersService.getAllRosters();
    }

    @GetMapping("/{teamName}/{id_player}/{yearStart}/{yearEnd}")
    public Optional<Rosters> getRostersById(@PathVariable String teamName,
                                            @PathVariable Integer id_player,
                                            @PathVariable Integer yearStart,
                                            @PathVariable Integer yearEnd) {

        return rostersService.getRostersById(teamName,id_player,yearStart,yearEnd);
    }
    @DeleteMapping("/{teamName}/{id_player}/{yearStart}/{yearEnd}")
    public void deleteRostersById(@PathVariable String teamName,
                                            @PathVariable Integer id_player,
                                            @PathVariable Integer yearStart,
                                            @PathVariable Integer yearEnd) {

        rostersService.deleteRosters(teamName,id_player,yearStart,yearEnd);
    }

}

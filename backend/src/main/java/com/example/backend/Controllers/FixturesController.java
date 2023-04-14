package com.example.backend.Controllers;

import com.example.backend.Model.Fixtures;
import com.example.backend.Model.Player;
import com.example.backend.Services.FixturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/fixtures")
public class FixturesController {
    @Autowired
    private FixturesService fixturesService;

    @GetMapping(value = "")
    public List<Fixtures> getAllFixtures() {
        return fixturesService.getAllFixtures();
    }

    @GetMapping("/{id}")
    public Optional<Fixtures> getFixturesById(@PathVariable Integer id) {
        return fixturesService.getFixturesById(id);
    }

    @PostMapping()
    public Fixtures saveFixtures(@RequestBody Fixtures fixtures) {
        return fixturesService.saveFixtures(fixtures);
    }
    @PutMapping("/{id}")
    public String updateFixtures(@PathVariable(value = "id") Integer id, @RequestBody Fixtures fixtures) throws ChangeSetPersister.NotFoundException {
        Optional<Fixtures> existingFixtures = fixturesService.getFixturesById(id);
        if(existingFixtures == null) {
            return "Not found";
        }
        Optional<Fixtures> fixturesOptional = fixturesService.getFixturesById(id);
        Fixtures optionalFixtures = fixturesOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        optionalFixtures.setMatch_id(fixtures.getMatch_id());
        optionalFixtures.setHome_team(fixtures.getHome_team());
        optionalFixtures.setAway_team(fixtures.getAway_team());
        optionalFixtures.setHome_goals(fixtures.getHome_goals());
        optionalFixtures.setAway_goals(fixtures.getAway_goals());
        optionalFixtures.setDatetime(fixtures.getDatetime());
        fixturesService.deleteFixtures(id);
        fixturesService.saveFixtures(optionalFixtures);
        return "Succesfully modified!";
    }

    @DeleteMapping("/{id}")
    public boolean deleteFixtures(@PathVariable Integer id) {
        fixturesService.deleteFixtures(id);
        return true;
    }
}

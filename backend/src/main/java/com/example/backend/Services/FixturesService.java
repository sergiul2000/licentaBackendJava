package com.example.backend.Services;

import com.example.backend.Model.Fixtures;
import com.example.backend.Repositories.FixturesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixturesService {
    @Autowired
    private FixturesRepo fixturesRepo;

    public List<Fixtures> getAllFixtures() {
        return fixturesRepo.findAll();
    }

    public Optional<Fixtures> getFixturesById(Integer id) {
        return fixturesRepo.findById(id);
    }

    public Fixtures saveFixtures(Fixtures fixtures) {
        if(fixturesRepo.existsById(fixtures.getMatch_id()))
            return null;
        return fixturesRepo.save(fixtures);
    }

    public void deleteFixtures(Integer id) {
        fixturesRepo.deleteById(id);
    }
}

package com.example.backend.Services;


import com.example.backend.Model.PlayerStatsEmbeddedId;
import com.example.backend.Model.Rosters;
import com.example.backend.Repositories.RostersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RostersService {
    @Autowired
    private RostersRepo rostersRepo;

    public List<Rosters> getAllRosters() {
        return rostersRepo.findAll();
    }

    public Optional<Rosters> getRostersById(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
        PlayerStatsEmbeddedId id = new PlayerStatsEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
        return rostersRepo.findById(id);
    }

    public Rosters saveRosters(Rosters rosters) {
        if(rostersRepo.existsById(rosters.getId()))
            return null;
        return rostersRepo.save(rosters);
    }

    public void deleteRosters(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
        PlayerStatsEmbeddedId id = new PlayerStatsEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
        rostersRepo.deleteById(id);
    }
}

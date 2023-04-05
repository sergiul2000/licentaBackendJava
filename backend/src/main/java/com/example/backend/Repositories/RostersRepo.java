package com.example.backend.Repositories;

import com.example.backend.Model.PlayerStatsEmbeddedId;
import com.example.backend.Model.Rosters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RostersRepo extends JpaRepository<Rosters, PlayerStatsEmbeddedId> {
}

package com.example.backend.Repositories;

import com.example.backend.Model.PlayerDefensiveStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDefensiveStatsRepo extends JpaRepository<PlayerDefensiveStats, Integer> {
}

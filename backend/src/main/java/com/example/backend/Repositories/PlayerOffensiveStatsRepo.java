package com.example.backend.Repositories;

import com.example.backend.Model.PlayerOffensiveStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerOffensiveStatsRepo extends JpaRepository<PlayerOffensiveStats,Integer> {
}

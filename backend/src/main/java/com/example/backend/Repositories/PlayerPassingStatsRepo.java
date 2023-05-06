package com.example.backend.Repositories;

import com.example.backend.Model.PlayerPassingStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerPassingStatsRepo extends JpaRepository<PlayerPassingStats,Integer> {
}

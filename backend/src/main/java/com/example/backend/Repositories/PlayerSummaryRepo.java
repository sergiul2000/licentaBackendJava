package com.example.backend.Repositories;

import com.example.backend.Model.PlayerSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerSummaryRepo extends JpaRepository<PlayerSummary,Integer> {
}

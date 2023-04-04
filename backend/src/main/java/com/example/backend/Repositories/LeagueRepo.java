package com.example.backend.Repositories;

import com.example.backend.Model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepo extends JpaRepository<League,String> {
}

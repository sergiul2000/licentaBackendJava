package com.example.backend.Repositories;

import com.example.backend.Model.League;
import com.example.backend.Model.LeagueTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepo extends JpaRepository<League,String> {
}

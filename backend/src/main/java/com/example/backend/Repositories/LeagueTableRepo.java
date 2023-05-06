package com.example.backend.Repositories;

import com.example.backend.Model.League;
import com.example.backend.Model.LeagueTable;
import com.example.backend.Model.LeagueTableEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface LeagueTableRepo extends JpaRepository<LeagueTable,Integer> {
//    Optional<LeagueTable> findLeagueTableById(Integer id);
//    void deleteById(LeagueTableEmbeddedId id);

//    List<LeagueTable> findByLeague(LeagueTableEmbeddedId id);
}

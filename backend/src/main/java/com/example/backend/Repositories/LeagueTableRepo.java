package com.example.backend.Repositories;

import com.example.backend.Model.LeagueTable;
import com.example.backend.Model.LeagueTableEmbeddedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface LeagueTableRepo extends JpaRepository<LeagueTable,LeagueTableEmbeddedId> {
    Optional<LeagueTable> findLeagueTableById(LeagueTableEmbeddedId id);
    void deleteById(LeagueTableEmbeddedId id);
}

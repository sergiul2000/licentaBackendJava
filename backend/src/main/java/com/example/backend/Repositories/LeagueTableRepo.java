package com.example.backend.Repositories;

import com.example.backend.Model.LeagueTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface LeagueTableRepo extends JpaRepository<LeagueTable,Integer> {
    Optional<LeagueTable> findById(String name,Integer yearStart,Integer yearEnd);


    void deleteByAllId
    (String teamName,Integer yearStart,Integer yearEnd);}

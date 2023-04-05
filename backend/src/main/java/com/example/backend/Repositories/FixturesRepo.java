package com.example.backend.Repositories;

import com.example.backend.Model.Fixtures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixturesRepo extends JpaRepository<Fixtures,Integer> {
}

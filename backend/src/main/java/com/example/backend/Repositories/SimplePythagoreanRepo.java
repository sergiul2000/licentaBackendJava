package com.example.backend.Repositories;

import com.example.backend.Model.SimplePythagorean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimplePythagoreanRepo extends JpaRepository<SimplePythagorean,Integer> {
}

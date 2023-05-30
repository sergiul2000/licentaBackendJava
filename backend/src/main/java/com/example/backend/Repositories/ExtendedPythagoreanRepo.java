package com.example.backend.Repositories;

import com.example.backend.Model.ExtendedPythagorean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtendedPythagoreanRepo  extends JpaRepository<ExtendedPythagorean,Integer> {
}

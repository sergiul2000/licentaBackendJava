package com.example.backend.Repositories;
import com.example.backend.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
    Optional<Player> findById(Integer id);
//    List<Player> findAll();
}

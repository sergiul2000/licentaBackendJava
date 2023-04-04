package com.example.backend.Services;

import com.example.backend.Model.Player;
import com.example.backend.Repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Optional<Player> getPlayerById(Integer id) {
        return playerRepo.findById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepo.save(player);
    }

    public void deletePlayer(Integer id) {
        playerRepo.deleteById(id);
    }
}
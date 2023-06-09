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
        if(playerRepo.existsById(player.getPlayer_id()))
            return null;
        return playerRepo.save(player);
    }

    public boolean deletePlayer(Integer id) {
        if(playerRepo.existsById(id)){
            playerRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
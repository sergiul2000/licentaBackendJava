package com.example.backend.Controllers;

import com.example.backend.Model.Player;
import com.example.backend.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/football-analytics/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "")
    public List<Player> getAllPlayers() {
        System.out.println("am ajuns aici controller!");
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping()
    public Player saveUser(@RequestBody Player player) {
        return playerService.saveUser(player);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}
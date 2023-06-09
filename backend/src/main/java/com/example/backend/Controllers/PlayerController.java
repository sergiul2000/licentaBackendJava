package com.example.backend.Controllers;

import com.example.backend.Model.Player;
import com.example.backend.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/football-analytics/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Integer id) {
        return playerService.getPlayerById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public Player savePlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public String updatePLayer(@PathVariable(value = "id") Integer id, @RequestBody Player player) throws ChangeSetPersister.NotFoundException {
        Optional<Player> existingPlayer = playerService.getPlayerById(id);
        if(existingPlayer == null) {
            return "Not found";
        }
        Optional<Player> playerOptional = playerService.getPlayerById(id);
        Player optionalPlayer = playerOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        optionalPlayer.setName(player.getName());
        optionalPlayer.setAge(player.getAge());
        optionalPlayer.setPosition(player.getPosition());
        optionalPlayer.setHeight(player.getHeight());
        optionalPlayer.setWeight(player.getWeight());
        playerService.deletePlayer(id);
        playerService.savePlayer(optionalPlayer);
        return "Succesfully modified!";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public boolean deletePlayer(@PathVariable Integer id) {
        return  playerService.deletePlayer(id);
//        return true;
    }
}
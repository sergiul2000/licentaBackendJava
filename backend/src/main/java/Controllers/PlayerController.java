package Controllers;

import Model.Player;
import Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/football-analytics/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<Player> getPlayerById(@PathVariable Integer id) {
        System.out.println("am ajuns aici controller!");
        return playerService.getPlayerById(id);
    }

    @PostMapping("")
    public Player saveUser(@RequestBody Player player) {
        return playerService.saveUser(player);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        playerService.deletePlayer(id);
    }
}
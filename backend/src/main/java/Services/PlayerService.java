package Services;

import Model.Player;
import Repositories.PlayerRepo;
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
        System.out.println("aici am ajuns!");
        return playerRepo.findById(id);
    }

    public Player saveUser(Player player) {
        return playerRepo.save(player);
    }

    public void deletePlayer(Integer id) {
        playerRepo.deleteById(id);
    }
}
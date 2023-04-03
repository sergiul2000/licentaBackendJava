package Repositories;
import Model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer> {
    Optional<Player> findById(Integer id);
//    List<Player> findAll();
}

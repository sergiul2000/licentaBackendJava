package com.example.backend.Repositories;

//import com.example.backend.Model.RostersEmbeddedId;
import com.example.backend.Model.Rosters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RostersRepo extends JpaRepository<Rosters, Integer> {
//    @Query("SELECT e from Rosters e where e.id.id_player = : parameter")
//    List<Rosters> findAllPlayersRosters(@Param("parameter") Integer playerId);
//    List<Rosters> getRostersByPlayerId(Integer playerId) ;

}

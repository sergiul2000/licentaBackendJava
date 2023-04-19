package com.example.backend.Services;


import com.example.backend.Model.Rosters;
import com.example.backend.Repositories.RostersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RostersService {
    @Autowired
    private RostersRepo rostersRepo;

    public List<Rosters> getAllRosters() {
        return rostersRepo.findAll();
    }

//    public Optional<Rosters> getRostersByAllRosterFileds(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
////        RostersEmbeddedId id = new RostersEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
//        return rostersRepo.findById(id);
//    }

    public Rosters saveRosters(Rosters rosters) {
        if(rostersRepo.existsById(rosters.getId_roster()))
            return null;

        return rostersRepo.save(rosters);
    }

    public boolean deleteRostersById(Integer id){//(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
//        RostersEmbeddedId id = new RostersEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
        if(rostersRepo.existsById(id)){
            rostersRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteRostersByAllFields(String teamName,Integer idPlayer,Integer yearStart,Integer yearEnd){//(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
//        RostersEmbeddedId id = new RostersEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
        Rosters response = new Rosters();
        List<Rosters> listRosters = rostersRepo.findAll();
        for(Rosters rosters: listRosters){
            if(rosters.getTeam().equals(teamName) &&
            rosters.getPlayer_id().intValue() == idPlayer &&
            rosters.getYear_start().intValue() == yearStart &&
            rosters.getYear_end().intValue() == yearEnd)
                response = rosters;
        }
        if(response==null)
            return false;
        rostersRepo.deleteById(response.getId_roster());
        return true;
    }

//    public List<Rosters> getAllRostersWithSpecifiedId(Integer id) {
//
//        RostersEmbeddedId rostersEmbeddedId = new RostersEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
//        System.out.println(rostersRepo.ge(id));
//        return rostersRepo.findAllPlayersRosters(id);
//    }
public Rosters getRostersByAllFields(String teamName,Integer idPlayer,Integer yearStart,Integer yearEnd){//(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
//        RostersEmbeddedId id = new RostersEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
    Rosters response = new Rosters();
    List<Rosters> listRosters = rostersRepo.findAll();
    for(Rosters rosters: listRosters){
        if(rosters.getTeam().equals(teamName) &&
                rosters.getPlayer_id().intValue() == idPlayer &&
                rosters.getYear_start().intValue() == yearStart &&
                rosters.getYear_end().intValue() == yearEnd)
            response = rosters;
    }
    return response;
}

    public Integer getRostersIdByAllFields(String teamName,Integer idPlayer,Integer yearStart,Integer yearEnd){//(String teamName, Integer idPlayer,Integer yearStart,Integer yearEnd) {
//        RostersEmbeddedId id = new RostersEmbeddedId(teamName,idPlayer,yearStart,yearEnd);
        Rosters response = new Rosters();
        List<Rosters> listRosters = rostersRepo.findAll();
        for(Rosters rosters: listRosters){
            if(rosters.getTeam().equals(teamName) &&
                    rosters.getPlayer_id().intValue() == idPlayer &&
                    rosters.getYear_start().intValue() == yearStart &&
                    rosters.getYear_end().intValue() == yearEnd)
                response = rosters;
        }
        return response.getId_roster();
    }

}

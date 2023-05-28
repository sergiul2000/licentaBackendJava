package com.example.backend.Controllers;

import com.example.backend.Model.Rosters;
import com.example.backend.Model.Team;
import com.example.backend.Services.RostersService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/football-analytics/rosters")

public class RostersController {
    @Autowired
    private RostersService rostersService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<Rosters> getAllRosters() {
        return rostersService.getAllRosters();
    }

//    @GetMapping("/{teamName}/{id_player}/{yearStart}/{yearEnd}")
//    public Optional<Rosters> getRostersById(@PathVariable String teamName,
//                                            @PathVariable Integer id_player,
//                                            @PathVariable Integer yearStart,
//                                            @PathVariable Integer yearEnd) {
//
//        return rostersService.getRostersById(teamName,id_player,yearStart,yearEnd);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "{id}")
    public boolean deleteById(@PathVariable Integer id){
        return rostersService.deleteRostersById(id);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public Rosters saveRosters(@RequestBody Rosters rosters) {
        System.out.println(rosters.getId_roster().getClass()+" "+rosters.getTeam().getClass()+" "+rosters.getPlayer_id().getClass()+" ");
        return rostersService.saveRosters(rosters);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{teamName}/{id_player}/{yearStart}/{yearEnd}")
    public String updateRosters(@PathVariable String teamName,
                                    @PathVariable  Integer id_player,
                                    @PathVariable Integer yearStart,
                                    @PathVariable Integer yearEnd,
                                    @RequestBody Rosters rosters) throws ChangeSetPersister.NotFoundException {
        Rosters existingRosters = rostersService.getRostersByAllFields(teamName,id_player,yearStart,yearEnd);
        if(existingRosters == null) {
            return "Not found";
        }
        Rosters rostersOptional = rostersService.getRostersByAllFields(teamName,id_player,yearStart,yearEnd);
//        Rosters optionalRosters = rostersOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        if(rostersOptional == null){
            throw new ChangeSetPersister.NotFoundException();
        }
        rostersOptional.setId_roster(rosters.getId_roster());
        rostersOptional.setTeam_name(rosters.getTeam());
        rostersOptional.setPlayer_id(rosters.getPlayer_id());
        rostersOptional.setYear_start(rosters.getYear_start());
        rostersOptional.setYear_end(rosters.getYear_end());
        rostersService.deleteRostersByAllFields(teamName,id_player,yearStart,yearEnd);
        rostersService.saveRosters(rostersOptional);
        return "Succesfully modified!";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{teamName}/{id_player}/{yearStart}/{yearEnd}")
    public boolean deleteRostersById(@PathVariable String teamName,
                                            @PathVariable Integer id_player,
                                            @PathVariable Integer yearStart,
                                            @PathVariable Integer yearEnd) {

        boolean response = rostersService.deleteRostersByAllFields(teamName,id_player,yearStart,yearEnd);
        return response;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id_player}")
    public List<Rosters> getRostersByPlayerId(@PathVariable Integer id_player) {
        List<Rosters> responseList = new ArrayList<>();
        List<Rosters> rosters =rostersService.getAllRosters();
//        rosters.forEach(x-> System.out.println(x.getId().getId_player()));
//        System.out.println(rosters.stream().filter(x -> x.getId().getId_player()== id_player));
        for(Rosters roster : rosters){
//            System.out.println(roster.getId().getId_player().getClass());
            if(roster.getPlayer_id().intValue() == id_player.intValue()){
//                System.out.println(roster.getId().getId_player());
                responseList.add(roster);
            }

        }
        return responseList;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{teamName}/{id_player}/{yearStart}/{yearEnd}")
    public List<Rosters> getRostersByAllFields(@PathVariable String teamName,
                                              @PathVariable Integer id_player,
                                              @PathVariable Integer yearStart,
                                              @PathVariable Integer yearEnd) {
        List<Rosters> responseList = new ArrayList<>();
        List<Rosters> rosters =rostersService.getAllRosters();
        for(Rosters roster : rosters){
            if(roster.getPlayer_id().intValue() == id_player.intValue() &&
                    roster.getTeam().equals(teamName) &&
                    roster.getYear_start().intValue() == yearStart.intValue() &&
                    roster.getYear_end().intValue() == yearEnd.intValue()){
                responseList.add(roster);
            }

        }
        return responseList;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{leagueName}/{yearStart}")
    public List<String> getRostersByYearStartAndLeague(@PathVariable String leagueName,
                                                     @PathVariable Integer yearStart) {
//        List<String> responseList = new ArrayList<>();

        Hashtable<String, String> hashResponseList = new Hashtable<>();
        List<Rosters> rosters =rostersService.getAllRosters();
        for(Rosters roster : rosters){
//            System.out.println(roster.getLeague_name().getLeague_name());
            if(roster.getLeague_name().getLeague_name().equals(leagueName) &&
                    roster.getYear_start().intValue() == yearStart.intValue()){
                hashResponseList.put(roster.getTeam_name().getTeam_name(),roster.getTeam_name().getTeam_name());
            }

        }
        List<String> responseList = new ArrayList<>();
        Enumeration<String> keys = hashResponseList.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
//            System.out.println("Key: " + key + ", Value: " + hashtable.get(key));
            responseList.add(hashResponseList.get(key));
        }
        return responseList;
    }


//    @GetMapping("/playersRosters/{id}")
//    public List<Rosters> getAllPlayersRosters(@PathVariable Integer id) {
//        return rostersService.getAllRostersWithSpecifiedId(id);
//    }

}

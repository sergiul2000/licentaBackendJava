package com.example.backend.Services;

import com.example.backend.Model.SimplePythagorean;
import com.example.backend.Repositories.SimplePythagoreanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimplePythagoreanService {

    @Autowired
    private SimplePythagoreanRepo simplePythagoreanRepo;

    public List<SimplePythagorean> getAllSimplePythagorean() {
        return simplePythagoreanRepo.findAll();
    }

    public Optional<SimplePythagorean> getSimplePythagoreanById(Integer id) {
        return simplePythagoreanRepo.findById(id);
    }
    public List<SimplePythagorean> getSimplePythagoreanByTeamAndYear(String leagueName,Integer yearStart) {
        List<SimplePythagorean> response = new ArrayList<>();
        List<SimplePythagorean> allTeams =  simplePythagoreanRepo.findAll();
        for(SimplePythagorean iterator : allTeams){
            if(iterator.getLeague_name().equals(leagueName) && (iterator.getYear_start().intValue() == yearStart.intValue())){
                response.add(iterator);
            }
        }
        return response;
    }




    public SimplePythagorean saveSimplePythagorean(SimplePythagorean simplePythagorean) {
        if(simplePythagoreanRepo.existsById(simplePythagorean.getSimple_pythagorean_id())){
            return null;
        }
        return simplePythagoreanRepo.save(simplePythagorean);
    }

    public void deleteSimplePythagorean(Integer id) {
        simplePythagoreanRepo.deleteById(id);
    }
}

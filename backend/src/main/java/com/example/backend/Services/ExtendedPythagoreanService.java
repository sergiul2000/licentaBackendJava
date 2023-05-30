package com.example.backend.Services;

import com.example.backend.Model.ExtendedPythagorean;
import com.example.backend.Model.SimplePythagorean;
import com.example.backend.Repositories.ExtendedPythagoreanRepo;
import com.example.backend.Repositories.SimplePythagoreanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExtendedPythagoreanService {

    @Autowired
    private ExtendedPythagoreanRepo extendedPythagoreanRepo;

    public List<ExtendedPythagorean> getAllExtendedPythagorean() {
        return extendedPythagoreanRepo.findAll();
    }

    public Optional<ExtendedPythagorean> getExtendedPythagoreanById(Integer id) {
        return extendedPythagoreanRepo.findById(id);
    }
    public List<ExtendedPythagorean> getExtendedPythagoreanByTeamAndYear(String leagueName,Integer yearStart) {
        List<ExtendedPythagorean> response = new ArrayList<>();
        List<ExtendedPythagorean> allTeams =  extendedPythagoreanRepo.findAll();
        for(ExtendedPythagorean iterator : allTeams){
            if(iterator.getLeague_name().equals(leagueName) && (iterator.getYear_start().intValue() == yearStart.intValue())){
                response.add(iterator);
            }
        }
        return response;
    }




    public ExtendedPythagorean saveExtendedPythagorean(ExtendedPythagorean extendedPythagorean) {
        if(extendedPythagoreanRepo.existsById(extendedPythagorean.getExtended_pythagorean_id())){
            return null;
        }
        return extendedPythagoreanRepo.save(extendedPythagorean);
    }

    public void deleteExtendedPythagorean(Integer id) {
        extendedPythagoreanRepo.deleteById(id);
    }
}

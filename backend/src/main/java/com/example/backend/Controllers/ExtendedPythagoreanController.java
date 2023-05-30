package com.example.backend.Controllers;

import com.example.backend.Model.SimplePythagorean;
import com.example.backend.Model.ExtendedPythagorean;
import com.example.backend.Services.ExtendedPythagoreanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/extendedPythagorean")
public class ExtendedPythagoreanController {


    @Autowired
    private ExtendedPythagoreanService extendedPythagoreanService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<ExtendedPythagorean> getAllSimplePythagorean() throws IOException {
        return extendedPythagoreanService.getAllExtendedPythagorean();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Optional<ExtendedPythagorean> getSimplePythagoreanById(
            @PathVariable Integer id) {
        return extendedPythagoreanService.getExtendedPythagoreanById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public ExtendedPythagorean saveExtendedPythagorean(@RequestBody ExtendedPythagorean extendedPythagorean) {
        return extendedPythagoreanService.saveExtendedPythagorean(extendedPythagorean);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public boolean deleteExtendedPythagorean(
            @PathVariable Integer id) {
        extendedPythagoreanService.deleteExtendedPythagorean(id);
        return true;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{leagueName}/{yearStart}")
    public List<ExtendedPythagorean> getExtendedPythagoreanByLeagueAndYearStart(@PathVariable String leagueName,@PathVariable Integer yearStart) {
//        List<ExtendedPythagorean>response = new ArrayList<>();
        List<ExtendedPythagorean>extendedPythagoreans = extendedPythagoreanService.getExtendedPythagoreanByTeamAndYear(leagueName,yearStart);
        return extendedPythagoreans;
    }
}

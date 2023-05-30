package com.example.backend.Controllers;

import com.example.backend.Model.SimplePythagorean;
import com.example.backend.Services.SimplePythagoreanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/football-analytics/simplePythagorean")
public class SimplePythagoreanController {

    @Autowired
    private SimplePythagoreanService simplePythagoreanService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "")
    public List<SimplePythagorean> getAllSimplePythagorean() throws IOException {
        return simplePythagoreanService.getAllSimplePythagorean();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public Optional<SimplePythagorean> getSimplePythagoreanById(
                                                    @PathVariable Integer id) {
        return simplePythagoreanService.getSimplePythagoreanById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public SimplePythagorean saveSimplePythagorean(@RequestBody SimplePythagorean simplePythagorean) {
        return simplePythagoreanService.saveSimplePythagorean(simplePythagorean);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public boolean deleteSimplePythagorean(
                                     @PathVariable Integer id) {
        simplePythagoreanService.deleteSimplePythagorean(id);
        return true;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{leagueName}/{yearStart}")
    public List<SimplePythagorean> getSimplePythagoreanByLeagueAndYearStart(@PathVariable String leagueName,@PathVariable Integer yearStart) {
//        List<SimplePythagorean>response = new ArrayList<>();
        List<SimplePythagorean>simplePythagoreans = simplePythagoreanService.getSimplePythagoreanByTeamAndYear(leagueName,yearStart);
        return simplePythagoreans;
    }

}

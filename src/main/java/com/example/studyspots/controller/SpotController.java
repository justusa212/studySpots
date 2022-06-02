package com.example.studyspots.controller;

import com.example.studyspots.model.Spot;
import com.example.studyspots.service.SpotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class SpotController {

    private final SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @PostMapping("/spots")
    public Spot saveUser(@RequestBody Spot spot) {
        return spotService.saveSpot(spot);
    }

    @GetMapping("/spots")
    public List<Spot> getAllSpots() {
        return spotService.getAllSpots();
    }

    @GetMapping("/spots/{id}")
    public ResponseEntity<Spot> getSpotById(@PathVariable("id") Long id) {
        Spot spot;
        spot = spotService.getSpotById(id);
        return ResponseEntity.ok(spot);
    }

    @DeleteMapping("/spots/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteSpot(@PathVariable("id") Long id) {
        boolean deleted;
        deleted = spotService.deleteSpot(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/spots/{id}")
    public ResponseEntity<Spot> updateUser(@PathVariable("id") Long id,
                                           @RequestBody Spot spot) {
        spot = spotService.updateSpot(id,spot);
        return ResponseEntity.ok(spot);
    }

}
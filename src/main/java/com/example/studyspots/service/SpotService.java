package com.example.studyspots.service;

import com.example.studyspots.model.Spot;

import java.util.List;

public interface SpotService {
    Spot saveSpot(Spot spot);

    List<Spot> getAllSpots();

    Spot getSpotById(Long id);

    boolean deleteSpot(Long id);

    Spot updateSpot(Long id, Spot spot);
}
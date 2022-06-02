package com.example.studyspots.service;

import com.example.studyspots.entity.SpotEntity;
import com.example.studyspots.model.Spot;
import com.example.studyspots.repository.SpotRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpotServiceImpl implements SpotService {

    private SpotRepository spotRepository;

    public SpotServiceImpl(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public Spot saveSpot(Spot spot) {
        SpotEntity spotEntity = new SpotEntity();
        BeanUtils.copyProperties(spot, spotEntity);
        spotRepository.save(spotEntity);
        return spot;
    }

    @Override
    public List<Spot> getAllSpots() {
        List<SpotEntity> spotEntities
                = spotRepository.findAll();

        List<Spot> spots = spotEntities
                .stream()
                .map(userEntity -> new Spot(
                        userEntity.getId(),
                        userEntity.getLocation(),
                        userEntity.getDescription()
                ))
                .collect(Collectors.toList());

        return spots;
    }

    @Override
    public Spot getSpotById(Long id) {
        SpotEntity userEntity
                = spotRepository.findById(id).get();
        Spot spot = new Spot();
        BeanUtils.copyProperties(userEntity, spot);
        return spot;
    }

    @Override
    public boolean deleteSpot(Long id) {
        SpotEntity spot =  spotRepository.findById(id).get();
        spotRepository.delete(spot);
        return true;
    }

    @Override
    public Spot updateSpot(Long id, Spot spot) {
        SpotEntity spotEntity =
                spotRepository.findById(id).get();
        spotEntity.setDescription(spot.getDescription());
        spotEntity.setLocation(spot.getLocation());

        spotRepository.save(spotEntity);
        return spot;
    }

}

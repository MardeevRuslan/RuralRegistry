package ru.respak.mardeev.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.respak.mardeev.entity.Area;
import ru.respak.mardeev.repository.AreaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
public class AreaServiceImpl implements AreaService {
    private final AreaRepository areaRepository;
    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<Area> getAllAreas() {
        return areaRepository.findAll().stream()
                .filter(area -> !area.isArchive())
                .collect(Collectors.toList());
    }

    @Override
    public List<Area> getAreas(String name, Long code) {
        return areaRepository.findByAreaNameAndAreaCode(name, code).stream()
                .filter(area -> !area.isArchive())
                .collect(Collectors.toList());
    }

    @Override
    public List<Area> getAreas(String name) {
        return areaRepository.findByAreaName(name).stream()
                .filter(area -> !area.isArchive())
                .collect(Collectors.toList());
    }

    @Override
    public List<Area> getAreas(Long code) {
        return areaRepository.findByAreaCode(code).stream()
                .filter(area -> !area.isArchive())
                .collect(Collectors.toList());
    }

    @Override
    public Area addArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(Long areaId, String newAreaName) {
        Optional<Area> optionalArea = areaRepository.findById(areaId);
        if (optionalArea.isPresent()) {
            Area existingArea = optionalArea.get();
            existingArea.setAreaName(newAreaName);
            return areaRepository.save(existingArea);
        }
        throw new IllegalArgumentException("Area not found");
    }


    @Override
    public Area updateArea(Long areaId, Long newAreaCode) {
        Optional<Area> optionalArea = areaRepository.findById(areaId);
        if (optionalArea.isPresent()) {
            Area existingArea = optionalArea.get();
            existingArea.setAreaCode(newAreaCode);
            return areaRepository.save(existingArea);
        }
        throw new IllegalArgumentException("Area not found");
    }

    @Override
    public void archiveArea(Long areaId) {
        Optional<Area> optionalArea = areaRepository.findById(areaId);
        if (optionalArea.isPresent()) {
            Area existingArea = optionalArea.get();
            existingArea.setArchive(true);
            areaRepository.save(existingArea);
        } else {
            throw new IllegalArgumentException("Area not found");
        }
    }


}

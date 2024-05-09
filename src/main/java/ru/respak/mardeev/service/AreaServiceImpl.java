package ru.respak.mardeev.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.respak.mardeev.entity.Area;
import ru.respak.mardeev.repository.AreaRepository;

import java.util.List;
import java.util.Optional;

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
        return areaRepository.findAll();
    }

    @Override
    public List<Area> getAreas(String name, Long code) {
        return areaRepository.findByAreaNameAndAreaCode(name, code);
    }

    @Override
    public List<Area> getAreas(String name) {
        return areaRepository.findByAreaName(name);
    }

    @Override
    public List<Area> getAreas(Long code) {
        return areaRepository.findByAreaCode(code);
    }

    @Override
    public Area addArea(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area updateArea(String areaName, long areaCode, Area area) {
        Optional<Area> optionalArea = areaRepository.findById(area.getId());
        if (optionalArea.isPresent()) {
            Area existingArea = optionalArea.get();
            existingArea.setAreaName(areaName);
            existingArea.setAreaCode(areaCode);
            return areaRepository.save(existingArea);
        }
        throw new IllegalArgumentException("Area not found");
    }

    @Override
    public void archiveArea(Area area) {
        Optional<Area> optionalArea = areaRepository.findById(area.getId());
        if (optionalArea.isPresent()) {
            Area existingArea = optionalArea.get();
            existingArea.setArchive(true);
            areaRepository.save(existingArea);
        } else {
            throw new IllegalArgumentException("Area not found");
        }
    }


}

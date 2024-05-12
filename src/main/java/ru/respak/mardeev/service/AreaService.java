package ru.respak.mardeev.service;

import ru.respak.mardeev.dto.AreaNameAndCodeDto;
import ru.respak.mardeev.dto.AreaNameDto;
import ru.respak.mardeev.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAllAreas();

    List<Area> getAreas(String name, Long code);

    Area addArea(AreaNameAndCodeDto area);

    List<Area> getAreas(String name);

    List<Area> getAreas(Long code);

    Area updateArea(Long areaId, String newAreaName);

    Area updateArea(Long areaId, Long newAreaCode);

    void archiveArea(Long areaId);

    Area addAreaByName(AreaNameDto area);
}

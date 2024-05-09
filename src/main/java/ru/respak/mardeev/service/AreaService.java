package ru.respak.mardeev.service;

import ru.respak.mardeev.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAllAreas();

    List<Area> getAreas(String name, Long code);

    Area addArea(Area area);

    List<Area> getAreas(String name);

    List<Area> getAreas(Long code);

    Area updateArea(String areaName, long areaCode, Area area);

    void archiveArea(Area area);
}

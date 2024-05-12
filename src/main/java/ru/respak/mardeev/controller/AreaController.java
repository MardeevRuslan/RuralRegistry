package ru.respak.mardeev.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.respak.mardeev.dto.AreaNameAndCodeDto;
import ru.respak.mardeev.dto.AreaNameDto;
import ru.respak.mardeev.entity.Area;
import ru.respak.mardeev.service.AreaService;

import java.util.List;

@RestController
@Data
@RequestMapping("/api/areas")
public class AreaController {
    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/all")
    public List<Area> getAllAreas() {
        return areaService.getAllAreas();
    }
    @GetMapping("/searchByNameAndCode")
    public List<Area> getAreasByNameAndCode(@RequestParam(name = "name") String name, @RequestParam(name = "code") Long code) {
        return areaService.getAreas(name, code);
    }


    @GetMapping("/searchByName")
    public List<Area> getAreasByName(@RequestParam(name = "name") String name) {
        return areaService.getAreas(name);
    }

    @GetMapping("/searchByCode")
    public List<Area> getAreasByCode(@RequestParam(name = "code") Long code) {
        return areaService.getAreas(code);
    }


    @PostMapping("/add")
    public Area addArea(@RequestBody AreaNameAndCodeDto area) {
        return areaService.addArea(area);
    }
    @PostMapping("/addByName")
    public Area addArea(@RequestBody AreaNameDto area) {
        return areaService.addAreaByName(area);
    }

    @PutMapping("/{areaId}/updateName")
    public Area updateAreaName(@PathVariable Long areaId, @RequestBody String newAreaName) {
        return areaService.updateArea(areaId, newAreaName);
    }

    @PutMapping("/{areaId}/updateCode")
    public Area updateAreaCode(@PathVariable Long areaId, @RequestBody Long newAreaCode) {
        return areaService.updateArea(areaId, newAreaCode);
    }


    @PutMapping("/{areaId}/archive")
    public void archiveArea(@PathVariable Long areaId) {
        areaService.archiveArea(areaId);
    }
}

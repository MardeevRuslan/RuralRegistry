package ru.respak.mardeev.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/search")
    public List<Area> getAreas(@RequestParam(required = false) String name, @RequestParam(required = false) Long code) {
        return areaService.getAreas(name, code);
    }

    @GetMapping("/search/name")
    public List<Area> getAreas(@RequestParam(required = false) String name) {
        return areaService.getAreas(name);
    }

    @GetMapping("/search/code")
    public List<Area> getAreas(@RequestParam(required = false) Long code) {
        return areaService.getAreas(code);
    }

    @PostMapping("/add")
    public Area addArea(@RequestBody Area area) {
        return areaService.addArea(area);
    }

    @PutMapping("/{areaName}")
    public Area updateArea(@PathVariable String areaName, @PathVariable Long areaCode, @RequestBody Area area) {
        return areaService.updateArea(areaName, areaCode, area);
    }

    @PutMapping("/{areaName}/archive")
    public void archiveArea(@RequestBody Area area) {
        areaService.archiveArea(area);
    }
}

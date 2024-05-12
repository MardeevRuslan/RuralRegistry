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
    public Area addArea(@RequestBody Area area) {
        return areaService.addArea(area);
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


//package ru.respak.mardeev.controller;
//
//        import io.swagger.v3.oas.annotations.Operation;
//        import io.swagger.v3.oas.annotations.Parameter;
//        import io.swagger.v3.oas.annotations.enums.ParameterIn;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.web.bind.annotation.*;
//        import ru.respak.mardeev.entity.Area;
//        import ru.respak.mardeev.service.AreaService;
//        import java.util.List;
//
//@RestController
//@RequestMapping("/api/areas")
//public class AreaController {
//    private final AreaService areaService;
//
//    @Autowired
//    public AreaController(AreaService areaService) {
//        this.areaService = areaService;
//    }
//
//    @GetMapping("/all")
////    @Operation(summary = "Get all areas", description = "Get details of all areas")
//    public List<Area> getAllAreas() {
//        return areaService.getAllAreas();
//    }
//
//    @GetMapping("/searchByNameAndCode")
//    @Operation(summary = "Search areas by name and code", description = "Search areas by name and code")
//    public List<Area> getAreasByNameAndCode(
//            @Parameter(description = "Area name", in = ParameterIn.QUERY) @RequestParam(name = "name") String name,
//            @Parameter(description = "Area code", in = ParameterIn.QUERY) @RequestParam(name = "code") Long code) {
//        return areaService.getAreas(name, code);
//    }
//
//    @GetMapping("/searchByName")
//    @Operation(summary = "Search areas by name", description = "Search areas by name")
//    public List<Area> getAreasByName(
//            @Parameter(description = "Area name", in = ParameterIn.QUERY) @RequestParam(name = "name") String name) {
//        return areaService.getAreas(name);
//    }
//
//    @GetMapping("/searchByCode")
//    @Operation(summary = "Search areas by code", description = "Search areas by code")
//    public List<Area> getAreasByCode(
//            @Parameter(description = "Area code", in = ParameterIn.QUERY) @RequestParam(name = "code") Long code) {
//        return areaService.getAreas(code);
//    }
//
//    @PostMapping("/add")
//    @Operation(summary = "Add new area", description = "Add a new area")
//    public Area addArea(@RequestBody Area area) {
//        return areaService.addArea(area);
//    }
//
//    @PutMapping("/{areaId}/updateName")
//    @Operation(summary = "Update area name", description = "Update area name by area ID")
//    public Area updateAreaName(
//            @Parameter(description = "Area ID", in = ParameterIn.PATH) @PathVariable Long areaId,
//            @RequestBody String newAreaName) {
//        return areaService.updateArea(areaId, newAreaName);
//    }
//
//    @PutMapping("/{areaId}/updateCode")
//    @Operation(summary = "Update area code", description = "Update area code by area ID")
//    public Area updateAreaCode(
//            @Parameter(description = "Area ID", in = ParameterIn.PATH) @PathVariable Long areaId,
//            @RequestBody Long newAreaCode) {
//        return areaService.updateArea(areaId, newAreaCode);
//    }
//
//    @PutMapping("/{areaId}/archive")
//    @Operation(summary = "Archive area", description = "Archive area by area ID")
//    public void archiveArea(
//            @Parameter(description = "Area ID", in = ParameterIn.PATH) @PathVariable Long areaId) {
//        areaService.archiveArea(areaId);
//    }
//}


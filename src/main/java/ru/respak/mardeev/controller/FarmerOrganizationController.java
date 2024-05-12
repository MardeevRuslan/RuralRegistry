package ru.respak.mardeev.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.respak.mardeev.entity.FarmerOrganization;
import ru.respak.mardeev.service.FarmerOrganizationService;

import java.util.List;

@RestController
@Data
@RequestMapping("/farmers")
public class FarmerOrganizationController {
    private  final FarmerOrganizationService farmerOrganizationService;

    @Autowired
    public FarmerOrganizationController(FarmerOrganizationService farmerOrganizationService) {
        this.farmerOrganizationService = farmerOrganizationService;
    }

    @GetMapping
    public List<FarmerOrganization> getFarmers() {
        return farmerOrganizationService.getAllFarmers();
    }

    @GetMapping("/{id}")
    public FarmerOrganization getFarmerById(@PathVariable long id) {
        return farmerOrganizationService.getFarmerById(id);
    }

    @PostMapping
    public FarmerOrganization addFarmer(@RequestBody FarmerOrganization farmer) {
        return farmerOrganizationService.addFarmer(farmer);
    }

    @PutMapping("/{id}")
    public FarmerOrganization updateFarmer(@PathVariable long id, @RequestBody FarmerOrganization farmer) {
        return farmerOrganizationService.updateFarmer(id, farmer);
    }

    @PutMapping("/{id}/archive")
    public FarmerOrganization archiveFarmer(@PathVariable long id) {
        return farmerOrganizationService.archiveFarmer(id);
    }
}

package ru.respak.mardeev.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.respak.mardeev.entity.FarmerOrganization;
import ru.respak.mardeev.service.FarmerOrganizationService;

import java.util.Date;
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

    @GetMapping("/all")
    public List<FarmerOrganization> getFarmers() {
        return farmerOrganizationService.getAllFarmers();
    }

    @GetMapping("/{id}")
    public FarmerOrganization getFarmerById(@PathVariable Long id) {
        return farmerOrganizationService.getFarmerById(id);
    }

    @GetMapping("/{organizationName}")
    public FarmerOrganization getFarmerById(@PathVariable String organizationName) {
        return farmerOrganizationService.getFarmerByOrganizationName(organizationName);
    }

    @GetMapping("/{INN}")
    public FarmerOrganization getFarmerByINN(@PathVariable Long INN) {
        return farmerOrganizationService.getFarmerByOrganizationINN(INN);
    }

    @GetMapping("/{areaId}")
    public FarmerOrganization getFarmerByAreaId(@PathVariable Long areaId) {
        return farmerOrganizationService.getFarmerByOrganizationArea(areaId);
    }

    @GetMapping("/{registrationDate}")
    public FarmerOrganization getFarmerByRegistrationDate(@PathVariable Date registrationDate) {
        return farmerOrganizationService.getFarmerByRegistrationDate(registrationDate);
    }
    @PostMapping
    public FarmerOrganization addFarmer(@RequestBody FarmerOrganization farmer) {
        return farmerOrganizationService.addFarmer(farmer);
    }

    @PutMapping("/{id}/updateName")
    public FarmerOrganization updateFarmerByOrganizationName(@PathVariable long id, @RequestBody String newFarmerName) {
        return farmerOrganizationService.updateFarmerByOrganizationName(id, newFarmerName);
    }

    @PutMapping("/{id}/updateINN")
    public FarmerOrganization updateFarmerByOrganizationINN(@PathVariable long id, @RequestBody Long newINN) {
        return farmerOrganizationService.updateFarmerByOrganizationINN(id, newINN);
    }

    @PutMapping("/{id}/updateKPP")
    public FarmerOrganization updateFarmerByOrganizationKPP(@PathVariable long id, @RequestBody Long newKPP) {
        return farmerOrganizationService.updateFarmerByOrganizationKPP(id, newKPP);
    }

    @PutMapping("/{id}/updateOGRN")
    public FarmerOrganization updateFarmerByOrganizationOGRN(@PathVariable long id, @RequestBody Long newOGRN) {
        return farmerOrganizationService.updateFarmerByOrganizationOGRN(id, newOGRN);
    }

    @PutMapping("/{id}/updateArea")
    public FarmerOrganization updateFarmerByArea(@PathVariable long id, @RequestBody Long newArea) {
        return farmerOrganizationService.updateFarmerByArea(id, newArea);
    }
    @PutMapping("/{id}/archive")
    public void archiveFarmer(@PathVariable long id) {
        farmerOrganizationService.archiveFarmer(id);
    }
}

package ru.respak.mardeev.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.respak.mardeev.dto.FarmerOrganizationDto;
import ru.respak.mardeev.entity.FarmerOrganization;
import ru.respak.mardeev.service.FarmerOrganizationService;

import java.util.Date;
import java.util.List;

@RestController
@Data
@RequestMapping("/api/farmers")
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

    @GetMapping("/byId/{id}")
    public FarmerOrganization getFarmerById(@PathVariable Long id) {
        return farmerOrganizationService.getFarmerById(id);
    }

    @PutMapping("/addCultivationAreas/{id}")
    public FarmerOrganization addCultivationAreas(@PathVariable Long id, @RequestBody Long areaIds) {
        return farmerOrganizationService.addCultivationAreas(id, areaIds);
    }
    @GetMapping("/byName/{organizationName}")
    public FarmerOrganization getFarmerByOrganizationName(@PathVariable String organizationName) {
        return farmerOrganizationService.getFarmerByOrganizationName(organizationName);
    }

    @GetMapping("/byINN/{INN}")
    public FarmerOrganization getFarmerByINN(@PathVariable Long INN) {
        return farmerOrganizationService.getFarmerByOrganizationINN(INN);
    }

    @GetMapping("/byAreaId/{areaId}")
    public FarmerOrganization getFarmerByAreaId(@PathVariable Long areaId) {
        return farmerOrganizationService.getFarmerByOrganizationArea(areaId);
    }

    @GetMapping("/byRegistrationDate/{registrationDate}")
    public FarmerOrganization getFarmerByRegistrationDate(@PathVariable Date registrationDate) {
        return farmerOrganizationService.getFarmerByRegistrationDate(registrationDate);
    }
    @PostMapping("/add")
    public FarmerOrganization addFarmer(@RequestBody FarmerOrganizationDto farmerDto) {
        return farmerOrganizationService.addFarmer(farmerDto);
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

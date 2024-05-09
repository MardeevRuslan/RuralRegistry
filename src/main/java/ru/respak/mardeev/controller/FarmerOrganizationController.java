package ru.respak.mardeev.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import ru.respak.mardeev.service.FarmerOrganizationService;

@RestController
@Data
public class FarmerOrganizationController {
    private  final FarmerOrganizationService farmerOrganizationService;

    @Autowired
    public FarmerOrganizationController(FarmerOrganizationService farmerOrganizationService) {
        this.farmerOrganizationService = farmerOrganizationService;
    }
}

package ru.respak.mardeev.service;

import ru.respak.mardeev.dto.FarmerOrganizationDto;
import ru.respak.mardeev.entity.FarmerOrganization;

import java.util.Date;
import java.util.List;

public interface FarmerOrganizationService {

    List<FarmerOrganization> getAllFarmers();

    FarmerOrganization getFarmerById(Long id);

    FarmerOrganization getFarmerByOrganizationName(String organizationName);

    FarmerOrganization getFarmerByOrganizationINN(Long inn);

    FarmerOrganization getFarmerByOrganizationArea(Long areaId);

    FarmerOrganization getFarmerByRegistrationDate(Date registrationDate);

    FarmerOrganization addFarmer(FarmerOrganizationDto farmerDto);

    FarmerOrganization updateFarmerByOrganizationName(long id, String newFarmerName);

    FarmerOrganization updateFarmerByOrganizationINN(long id, Long newINN);

    FarmerOrganization updateFarmerByOrganizationKPP(long id, Long newKPP);

    FarmerOrganization updateFarmerByOrganizationOGRN(long id, Long newOGRN);

    FarmerOrganization updateFarmerByArea(long id, Long newArea);

    void archiveFarmer(long id);

    FarmerOrganization addCultivationAreas(Long id, Long areaIds);
}

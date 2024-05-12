package ru.respak.mardeev.service;

import ru.respak.mardeev.entity.FarmerOrganization;

import java.util.List;

public interface FarmerOrganizationService {
    List<FarmerOrganization> getAllFarmers();

    FarmerOrganization getFarmerById(long id);

    FarmerOrganization addFarmer(FarmerOrganization farmer);

    FarmerOrganization updateFarmer(long id, FarmerOrganization farmer);

    FarmerOrganization archiveFarmer(long id);
}

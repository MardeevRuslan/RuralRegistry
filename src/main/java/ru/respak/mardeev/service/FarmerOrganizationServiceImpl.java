package ru.respak.mardeev.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.respak.mardeev.entity.FarmerOrganization;
import ru.respak.mardeev.repository.FarmerOrganizationRepository;

import java.util.List;

@Service
@Data
public class FarmerOrganizationServiceImpl implements FarmerOrganizationService {
    private final FarmerOrganizationRepository farmerOrganizationRepository;
    @Autowired
    public FarmerOrganizationServiceImpl(FarmerOrganizationRepository farmerOrganizationRepository) {
        this.farmerOrganizationRepository = farmerOrganizationRepository;
    }

    @Override
    public List<FarmerOrganization> getAllFarmers() {
        return null;
    }

    @Override
    public FarmerOrganization getFarmerById(long id) {
        return null;
    }

    @Override
    public FarmerOrganization addFarmer(FarmerOrganization farmer) {
        return null;
    }

    @Override
    public FarmerOrganization updateFarmer(long id, FarmerOrganization farmer) {
        return null;
    }

    @Override
    public FarmerOrganization archiveFarmer(long id) {
        return null;
    }
}

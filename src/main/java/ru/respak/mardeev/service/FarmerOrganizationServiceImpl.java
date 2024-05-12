package ru.respak.mardeev.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.respak.mardeev.entity.Area;
import ru.respak.mardeev.entity.FarmerOrganization;
import ru.respak.mardeev.repository.AreaRepository;
import ru.respak.mardeev.repository.FarmerOrganizationRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class FarmerOrganizationServiceImpl implements FarmerOrganizationService {
    private final FarmerOrganizationRepository farmerOrganizationRepository;
    private final AreaRepository areaRepository;

    @Autowired
    public FarmerOrganizationServiceImpl(FarmerOrganizationRepository farmerOrganizationRepository,
                                         AreaRepository areaRepository) {
        this.farmerOrganizationRepository = farmerOrganizationRepository;
        this.areaRepository = areaRepository;
    }


    @Override
    public List<FarmerOrganization> getAllFarmers() {
        return farmerOrganizationRepository.findAll().stream()
                .filter(farmerOrganization -> !farmerOrganization.isArchive())
                .collect(Collectors.toList());
    }

    @Override
    public FarmerOrganization getFarmerById(Long id) {
        return farmerOrganizationRepository.findById(id).orElse(null);
    }

    @Override
    public FarmerOrganization getFarmerByOrganizationName(String organizationName) {
        return farmerOrganizationRepository.findByOrganizationName(organizationName).orElse(null);
    }

    @Override
    public FarmerOrganization getFarmerByOrganizationINN(Long inn) {
        return farmerOrganizationRepository.findByINN(inn).orElse(null);
    }

    @Override
    public FarmerOrganization getFarmerByOrganizationArea(Long areaId) {
        return farmerOrganizationRepository.findByAreaId(areaId).orElse(null);
    }

    @Override
    public FarmerOrganization getFarmerByRegistrationDate(Date registrationDate) {
        return farmerOrganizationRepository.findByRegistrationDate(registrationDate).orElse(null);
    }

    @Override
    public FarmerOrganization addFarmer(FarmerOrganization farmer) {
        if (areaRepository.findById(farmer.getAreaId()).orElse(null) == null) {
            throw new IllegalArgumentException("Area not found");
        }
        return farmerOrganizationRepository.save(farmer);
    }

    @Override
    public FarmerOrganization updateFarmerByOrganizationName(long id, String newFarmerName) {
        FarmerOrganization farmerOrganization = farmerOrganizationRepository.findById(id).orElse(null);
        if (farmerOrganization == null) {
            throw new IllegalArgumentException("Farmer not found");
        }
        farmerOrganization.setOrganizationName(newFarmerName);
        return farmerOrganizationRepository.save(farmerOrganization);
    }

    @Override
    public FarmerOrganization updateFarmerByOrganizationINN(long id, Long newINN) {
        FarmerOrganization farmerOrganization = farmerOrganizationRepository.findById(id).orElse(null);
        if (farmerOrganization == null) {
            throw new IllegalArgumentException("Farmer not found");
        }
        farmerOrganization.setINN(newINN);
        return farmerOrganizationRepository.save(farmerOrganization);
    }

    @Override
    public FarmerOrganization updateFarmerByOrganizationKPP(long id, Long newKPP) {
        FarmerOrganization farmerOrganization = farmerOrganizationRepository.findById(id).orElse(null);
        if (farmerOrganization == null) {
            throw new IllegalArgumentException("Farmer not found");
        }
        farmerOrganization.setKPP(newKPP);
        return farmerOrganizationRepository.save(farmerOrganization);
    }

    @Override
    public FarmerOrganization updateFarmerByOrganizationOGRN(long id, Long newOGRN) {
        FarmerOrganization farmerOrganization = farmerOrganizationRepository.findById(id).orElse(null);
        if (farmerOrganization == null) {
            throw new IllegalArgumentException("Farmer not found");
        }
        farmerOrganization.setOGRN(newOGRN);
        return farmerOrganizationRepository.save(farmerOrganization);
    }

    @Override
    public FarmerOrganization updateFarmerByArea(long id, Long newArea) {
        FarmerOrganization farmerOrganization = farmerOrganizationRepository.findById(id).orElse(null);
        Area area = areaRepository.findById(newArea).orElse(null);
        if (farmerOrganization == null || area == null) {
            throw new IllegalArgumentException("Farmer or area not found");
        }
        farmerOrganization.setAreaId(newArea);
        return farmerOrganizationRepository.save(farmerOrganization);
    }

    @Override
    public void archiveFarmer(long id) {
        FarmerOrganization farmerOrganization = farmerOrganizationRepository.findById(id).orElse(null);
        if (farmerOrganization == null) {
            throw new IllegalArgumentException("Farmer not found");
        }
        farmerOrganization.setArchive(true);
        farmerOrganizationRepository.save(farmerOrganization);
    }
}

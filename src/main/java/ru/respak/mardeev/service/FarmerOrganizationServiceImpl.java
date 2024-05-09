package ru.respak.mardeev.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.respak.mardeev.repository.FarmerOrganizationRepository;

@Service
@Data
public class FarmerOrganizationServiceImpl implements FarmerOrganizationService {
    private final FarmerOrganizationRepository farmerOrganizationRepository;
    @Autowired
    public FarmerOrganizationServiceImpl(FarmerOrganizationRepository farmerOrganizationRepository) {
        this.farmerOrganizationRepository = farmerOrganizationRepository;
    }
}

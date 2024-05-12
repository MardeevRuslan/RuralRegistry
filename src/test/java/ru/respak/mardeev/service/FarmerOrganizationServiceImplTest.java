package ru.respak.mardeev.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.respak.mardeev.entity.Area;
import ru.respak.mardeev.entity.FarmerOrganization;
import ru.respak.mardeev.repository.AreaRepository;
import ru.respak.mardeev.repository.FarmerOrganizationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FarmerOrganizationServiceImplTest {

    @Mock
    private FarmerOrganizationRepository farmerOrganizationRepository;

    @Mock
    private AreaRepository areaRepository;

    @InjectMocks
    private FarmerOrganizationServiceImpl farmerOrganizationService;

    @Test
    public void testGetAllFarmers() {
        List<FarmerOrganization> farmers = new ArrayList<>();
        farmers.add(new FarmerOrganization());
        farmers.add(new FarmerOrganization());
        when(farmerOrganizationRepository.findAll()).thenReturn(farmers);

        List<FarmerOrganization> result = farmerOrganizationService.getAllFarmers();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetFarmerById() {
        FarmerOrganization farmer = new FarmerOrganization();
        farmer.setId(1L);
        when(farmerOrganizationRepository.findById(1L)).thenReturn(Optional.of(farmer));

        FarmerOrganization result = farmerOrganizationService.getFarmerById(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetFarmerByOrganizationName() {
        FarmerOrganization farmer = new FarmerOrganization();
        farmer.setOrganizationName("Test Organization");
        when(farmerOrganizationRepository.findByOrganizationName("Test Organization")).thenReturn(Optional.of(farmer));

        FarmerOrganization result = farmerOrganizationService.getFarmerByOrganizationName("Test Organization");
        assertEquals("Test Organization", result.getOrganizationName());
    }

    @Test
    public void testGetFarmerByOrganizationINN() {
        FarmerOrganization farmer = new FarmerOrganization();
        farmer.setINN(1234567890L);
        when(farmerOrganizationRepository.findByINN(1234567890L)).thenReturn(Optional.of(farmer));

        FarmerOrganization result = farmerOrganizationService.getFarmerByOrganizationINN(1234567890L);
        assertEquals(1234567890L, result.getINN());
    }

    @Test
    public void testGetFarmerByOrganizationArea() {
        Area area = new Area("Test Area", 123);
        FarmerOrganization farmer = new FarmerOrganization();
        farmer.setRegistrationArea(area);
        when(areaRepository.findById(1L)).thenReturn(Optional.of(area));
        when(farmerOrganizationRepository.findByRegistrationArea(area)).thenReturn(Optional.of(farmer));
        FarmerOrganization result = farmerOrganizationService.getFarmerByOrganizationArea(1L);
        assertNotNull(result);
        assertEquals(area, result.getRegistrationArea());
    }

    @Test
    public void testGetFarmerByRegistrationDate() {
        Date registrationDate = new Date();
        FarmerOrganization farmer = new FarmerOrganization();
        farmer.setRegistrationDate(registrationDate);
        when(farmerOrganizationRepository.findByRegistrationDate(registrationDate)).thenReturn(Optional.of(farmer));

        FarmerOrganization result = farmerOrganizationService.getFarmerByRegistrationDate(registrationDate);
        assertNotNull(result);
        assertEquals(registrationDate, result.getRegistrationDate());
    }
}


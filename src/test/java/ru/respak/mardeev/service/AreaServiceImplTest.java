package ru.respak.mardeev.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;
import ru.respak.mardeev.dto.AreaNameAndCodeDto;
import ru.respak.mardeev.dto.AreaNameDto;
import ru.respak.mardeev.entity.Area;
import ru.respak.mardeev.repository.AreaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Transactional
class AreaServiceImplTest {
    @Mock
    private AreaRepository areaRepository;

    @InjectMocks
    private AreaServiceImpl areaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllAreas() {
        List<Area> areas = Arrays.asList(new Area("Area 1"), new Area("Area 2"));
        when(areaRepository.findAll()).thenReturn(areas);
        List<Area> result = areaService.getAllAreas();
        assertEquals(areas, result);
    }

    @Test
    void getAreasByNameAndCode() {
        List<Area> areas = Arrays.asList(new Area("Area 1", 1L), new Area("Area 2", 2L));
        when(areaRepository.findByAreaNameAndAreaCode("Area 1", 1L)).thenReturn(areas);
        List<Area> result = areaService.getAreas("Area 1", 1L);
        assertEquals(areas, result);
    }

    @Test
    void getAreasByName() {
        List<Area> areas = Arrays.asList(new Area("Area 1"), new Area("Area 2"));
        when(areaRepository.findByAreaName("Area 1")).thenReturn(areas);
        List<Area> result = areaService.getAreas("Area 1");
        assertEquals(areas, result);
    }

    @Test
    void getAreasByCode() {
        List<Area> areas = Arrays.asList(new Area("Area 1", 1L), new Area("Area 2", 1L));
        when(areaRepository.findByAreaCode(1L)).thenReturn(areas);
        List<Area> result = areaService.getAreas(1L);
        assertEquals(areas, result);
    }

    @Test
    void addArea() {
        AreaNameAndCodeDto area = new AreaNameAndCodeDto("Area 1", 1L);
        Area expectedArea = new Area("Area 1", 1L);
        when(areaRepository.save(any(Area.class))).thenReturn(expectedArea);
        Area result = areaService.addArea(area);
        assertEquals(expectedArea, result);
    }

    @Test
    void updateAreaByName() {
        Long areaId = 1L;
        String newAreaName = "New Area Name";
        Area existingArea = new Area("Area 1", 1L);
        when(areaRepository.findById(areaId)).thenReturn(Optional.of(existingArea));
        Area expectedArea = new Area("New Area Name", 1L);
        when(areaRepository.save(any(Area.class))).thenReturn(expectedArea);
        Area result = areaService.updateArea(areaId, newAreaName);
        assertEquals(expectedArea, result);
    }
}
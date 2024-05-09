package ru.respak.mardeev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.respak.mardeev.entity.Area;

import java.util.List;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findByAreaNameAndAreaCode(String name, Long code);

    List<Area> findByAreaName(String name);

    List<Area> findByAreaCode(Long code);
}

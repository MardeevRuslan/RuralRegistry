package ru.respak.mardeev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.respak.mardeev.entity.FarmerOrganization;

import java.util.Date;
import java.util.Optional;

@Repository
public interface FarmerOrganizationRepository extends JpaRepository<FarmerOrganization, Long> {
    Optional<FarmerOrganization> findByOrganizationName(String organizationName);

    Optional<FarmerOrganization> findByINN(Long inn);

    Optional<FarmerOrganization> findByAreaId(Long areaId);

    Optional<FarmerOrganization> findByRegistrationDate(Date registrationDate);
}

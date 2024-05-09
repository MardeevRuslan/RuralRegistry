package ru.respak.mardeev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.respak.mardeev.entity.FarmerOrganization;

@Repository
public interface FarmerOrganizationRepository extends JpaRepository<FarmerOrganization, Long> {
}

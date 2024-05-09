package ru.respak.mardeev.entity;

import lombok.Data;
import ru.respak.mardeev.helpers.OrganizationalLegalForm;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "farmer_organization_table")
public class FarmerOrganization {

    @Id
    private String organizationName;
    private OrganizationalLegalForm organizationalLegalForm;
    private long INN;
    private long KPP;
    private long OGRN;
    @OneToOne(targetEntity = Area.class)
    @JoinColumn(name = "area_name")
    private Area areaRegistration;
    @OneToMany(targetEntity = Area.class)
    @JoinColumn(name = "area_name")
    private List<Area> cropsFieldsAreas;
    private Date registrationDate;
    private boolean isArchive;
}

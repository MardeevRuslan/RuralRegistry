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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private long id;
    @Column(name = "organization_name", nullable = false)
    private String organizationName;
    @Column(name = "organizational_legal_form")
    private OrganizationalLegalForm organizationalLegalForm;
    @Column(name = "INN", nullable = false)
    private long INN;
    @Column(name = "KPP")
    private long KPP;
    @Column(name = "OGRN")
    private long OGRN;

//    @OneToOne(targetEntity = Area.class)
//    @JoinColumn(name = "area_id")
//    private Area areaRegistration;
//    @OneToMany(targetEntity = Area.class)
//    @JoinColumn(name = "area_id")
//    private List<Area> cropsFieldsAreas;

    @Column(name = "area_id", nullable = false) // Добавляем внешний ключ
    private long areaId; // Идентификатор области, ссылается на area_id в таблице area_table
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", insertable = false, updatable = false)
    private Area area; // Добавляем объект Area для доступа к связанной области

    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "is_archive")
    private boolean isArchive;
}

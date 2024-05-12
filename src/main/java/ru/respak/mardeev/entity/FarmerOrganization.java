package ru.respak.mardeev.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.respak.mardeev.helpers.OrganizationalLegalForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "registration_area_id")
    private Area registrationArea;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "farmer_organization_area",
            joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "area_id"))
    private List<Area> cultivationAreas = new ArrayList<>();

    @Column(name = "registration_date")
    private Date registrationDate;
    @Column(name = "is_archive")
    private boolean isArchive = false;

}

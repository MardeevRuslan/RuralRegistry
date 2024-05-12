package ru.respak.mardeev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "area_table")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private long id;
    @Column(name = "area_name", nullable = false)
    private String areaName;
    @Column(name = "area_code")
    private long areaCode;
    @Column(name = "is_archive")
    private boolean isArchive = false;

    @OneToMany(mappedBy = "registrationArea", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<FarmerOrganization> registeredFarmers = new ArrayList<>();

    @ManyToMany(mappedBy = "cultivationAreas", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<FarmerOrganization> farmers = new ArrayList<>();

    public Area(String areaName, long areaCode) {
        this.areaName = areaName;
        this.areaCode = areaCode;
    }

    public Area(String areaName) {
        this.areaName = areaName;
    }

}

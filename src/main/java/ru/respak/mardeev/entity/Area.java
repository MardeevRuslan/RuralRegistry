package ru.respak.mardeev.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
    private boolean isArchive;
}

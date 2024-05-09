package ru.respak.mardeev.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "area_table")
public class Area {
    @Id
    private String areaName;
    @Column(name = "area_code")
    private long areaCode;
    @Column(name = "is_archive")
    private boolean isArchive;
}

package ru.respak.mardeev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AreaNameAndCodeDto {
    private String areaName;
    private Long areaCode;
}

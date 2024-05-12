package ru.respak.mardeev.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.respak.mardeev.helpers.OrganizationalLegalForm;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerOrganizationDto {
    @ApiModelProperty(required = true)
    private String organizationName;
    @ApiModelProperty(required = true)
    private long INN;
    @ApiModelProperty(required = true)
    private long areaId;
    private OrganizationalLegalForm organizationalLegalForm;
    private long KPP;
    private long OGRN;
    private Date registrationDate;
}

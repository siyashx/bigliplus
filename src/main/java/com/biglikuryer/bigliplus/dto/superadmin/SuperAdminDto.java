package com.biglikuryer.bigliplus.dto.superadmin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SuperAdminDto {

    private Long id;

    private Boolean isActive;
}

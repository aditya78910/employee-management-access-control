package com.concertai.accesscontrol.dto.req.access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GrantPermissionDTO {
    private Long userId;
    private Long resourceId;
    private Long permissionId;
}

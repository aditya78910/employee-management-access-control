package com.concertai.accesscontrol.dto.res.access;

import com.concertai.accesscontrol.entity.authorization.AccessControlUserResourcePermissionMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResourcePermissionsResponseDTO {
    private List<AccessControlUserResourcePermissionMapping> accessControlUserResourcePermissionMappingList;
}

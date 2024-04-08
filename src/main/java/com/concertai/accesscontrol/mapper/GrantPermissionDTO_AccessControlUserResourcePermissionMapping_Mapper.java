package com.concertai.accesscontrol.mapper;

import com.concertai.accesscontrol.dto.req.access.GrantPermissionDTO;
import com.concertai.accesscontrol.entity.authorization.AccessControlPermission;
import com.concertai.accesscontrol.entity.authorization.AccessControlResource;
import com.concertai.accesscontrol.entity.authorization.AccessControlUserResourcePermissionMapping;
import org.springframework.stereotype.Component;

@Component
public class GrantPermissionDTO_AccessControlUserResourcePermissionMapping_Mapper {
    public AccessControlUserResourcePermissionMapping toEntity(GrantPermissionDTO grantPermissionDTO){
        return AccessControlUserResourcePermissionMapping.builder()
                .userId(grantPermissionDTO.getUserId())
                .accessControlResource(AccessControlResource.builder()
                        .id(grantPermissionDTO.getResourceId())
                        .build())
                .accessControlPermission(AccessControlPermission.builder()
                        .id(grantPermissionDTO.getPermissionId())
                        .build())
                .build();
    }
}

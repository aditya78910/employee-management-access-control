package com.concertai.accesscontrol.controller;

import com.concertai.accesscontrol.dto.req.access.GrantPermissionDTO;
import com.concertai.accesscontrol.entity.authorization.AccessControlUserResourcePermissionMapping;
import com.concertai.accesscontrol.mapper.GrantPermissionDTO_AccessControlUserResourcePermissionMapping_Mapper;
import com.concertai.accesscontrol.service.authorization.AccessControlUserResourcePermissionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grant")
@AllArgsConstructor
public class AccessGrantController {

    GrantPermissionDTO_AccessControlUserResourcePermissionMapping_Mapper
            grantPermissionDTOAccessControlUserResourcePermissionMappingMapper;

    AccessControlUserResourcePermissionsService accessControlUserResourcePermissionsService;

    @PostMapping
    public AccessControlUserResourcePermissionMapping grantPermissionToUser(@RequestBody GrantPermissionDTO grantPermissionDTO){
        AccessControlUserResourcePermissionMapping permissionEntity =
                grantPermissionDTOAccessControlUserResourcePermissionMappingMapper.toEntity(grantPermissionDTO);
        return accessControlUserResourcePermissionsService.grantPermissionToUser(permissionEntity);
    }
}

package com.concertai.accesscontrol.controller;

import com.concertai.accesscontrol.entity.authorization.AccessControlUserResourcePermissionMapping;
import com.concertai.accesscontrol.dto.req.access.UserResourcePermissionRequestDTO;
import com.concertai.accesscontrol.dto.res.access.UserResourcePermissionsResponseDTO;
import com.concertai.accesscontrol.service.authorization.AccessControlUserResourcePermissionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/permissions")
public class AccessController {

    AccessControlUserResourcePermissionsService aclUserResourcePermissionsService;

    /**
     *  Get the permissions belonging a user and a resource.
     *  If resource is missing, get all permissions belonging to a user
     * @param requestDTO
     * @return
     */
    @PostMapping
    public UserResourcePermissionsResponseDTO getUserResourcePermissions(
            @RequestBody UserResourcePermissionRequestDTO requestDTO ){

        List<AccessControlUserResourcePermissionMapping> permissionsForUser =
                aclUserResourcePermissionsService.getResourcePermissionsForUser(requestDTO);

        return UserResourcePermissionsResponseDTO.builder()
                        .accessControlUserResourcePermissionMappingList(permissionsForUser)
                        .build();
    }

}

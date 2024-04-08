package com.concertai.accesscontrol.service.authorization;

import com.concertai.accesscontrol.entity.authorization.AccessControlUserResourcePermissionMapping;
import com.concertai.accesscontrol.dto.req.access.UserResourcePermissionRequestDTO;
import com.concertai.accesscontrol.repository.authorization.AccessControlUserResourcePermissionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class AccessControlUserResourcePermissionsService {

    AccessControlUserResourcePermissionsRepository accessControlUserResourcePermissionsRepository;

    public List<AccessControlUserResourcePermissionMapping> getResourcePermissionsForUser(UserResourcePermissionRequestDTO userResourcePermissionRequestDTO){

        if(!ObjectUtils.isEmpty(userResourcePermissionRequestDTO.getResourceId())) {

            return accessControlUserResourcePermissionsRepository
                    .findByUserIdAndResourceIdAndResourceName(
                            userResourcePermissionRequestDTO.getUserId(),
                            userResourcePermissionRequestDTO.getResourceId(),
                            userResourcePermissionRequestDTO.getResourceName());
        }else{
            return accessControlUserResourcePermissionsRepository.findByUserId(
                    userResourcePermissionRequestDTO.getUserId());
        }
    }

    public AccessControlUserResourcePermissionMapping grantPermissionToUser(AccessControlUserResourcePermissionMapping accessControlUserResourcePermissionMapping){
        return accessControlUserResourcePermissionsRepository.save(accessControlUserResourcePermissionMapping);
    }
}

package com.concertai.accesscontrol.repository.authorization;

import com.concertai.accesscontrol.entity.authorization.AccessControlUserResourcePermissionMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessControlUserResourcePermissionsRepository
        extends JpaRepository<AccessControlUserResourcePermissionMapping, Long> {
    List<AccessControlUserResourcePermissionMapping> findByUserId(Long userId);
    List<AccessControlUserResourcePermissionMapping> findByUserIdAndAccessControlResource_resourceIdAndAccessControlResource_resourceName(Long userId, String resourceId, String resourceName);
    default List<AccessControlUserResourcePermissionMapping> findByUserIdAndResourceIdAndResourceName(Long userId, String resourceId, String resourceName){
        return findByUserIdAndAccessControlResource_resourceIdAndAccessControlResource_resourceName(userId, resourceId, resourceName);
    }

}

package com.concertai.accesscontrol.entity.authorization;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "access_control_user_resource_permission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessControlUserResourcePermissionMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "resourceId", referencedColumnName = "id")
    @JsonManagedReference
    private com.concertai.accesscontrol.entity.authorization.AccessControlResource accessControlResource;

    @ManyToOne
    @JoinColumn(name = "permissionId")
    @JsonManagedReference
    private com.concertai.accesscontrol.entity.authorization.AccessControlPermission accessControlPermission;
}

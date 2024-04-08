A fine grained permissions based access control system.

It contains 3 entities

1. AccessControlResource - It can be any resource to which the access has to be configured.For example an Employee with id 2 or a Department with id 1
2. AccessControlPermission - These are the permissions - For eg. employee:view, employee:create, employee:update, employee:delete, department:view and so on
3. AccessControlUserResourcePermissionMapping - These are the permission mappings, For example a user with id 1 is assigned an employee:view permission on his own Employee record.


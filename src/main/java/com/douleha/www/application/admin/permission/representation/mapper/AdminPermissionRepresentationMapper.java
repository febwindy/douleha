package com.douleha.www.application.admin.permission.representation.mapper;

import com.douleha.www.application.admin.permission.representation.AdminPermissionRepresentation;
import com.douleha.www.domain.model.permission.Permission;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by ivan_ on 2015/9/16.
 */
@Component
public class AdminPermissionRepresentationMapper extends CustomMapper<Permission, AdminPermissionRepresentation> {
    @Override
    public void mapAtoB(Permission permission, AdminPermissionRepresentation adminPermissionRepresentation, MappingContext context) {
        super.mapAtoB(permission, adminPermissionRepresentation, context);
    }
}

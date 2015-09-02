package com.douleha.www.application.admin.role.representation.mapper;

import com.douleha.www.application.admin.role.representation.AdminRoleRepresentation;
import com.douleha.www.domain.model.role.Role;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by ivan_ on 2015/9/2.
 */
@Component
public class AdminRoleRepresentationMapper extends CustomMapper<Role, AdminRoleRepresentation> {

    @Override
    public void mapAtoB(Role role, AdminRoleRepresentation adminRoleRepresentation, MappingContext context) {
        super.mapAtoB(role, adminRoleRepresentation, context);
    }
    
}

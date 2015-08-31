package com.douleha.www.application.admin.user.representation.mapper;

import com.douleha.www.application.admin.user.representation.AdminUserRepresentation;
import com.douleha.www.domain.model.user.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by ivan_ on 2015/8/31.
 */
@Component
public class AdminUserRepresentationMapper extends CustomMapper<User, AdminUserRepresentation> {

    @Override
    public void mapAtoB(User user, AdminUserRepresentation adminUserRepresentation, MappingContext context) {
        super.mapAtoB(user, adminUserRepresentation, context);
    }

}

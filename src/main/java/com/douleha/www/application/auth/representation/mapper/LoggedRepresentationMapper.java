package com.douleha.www.application.auth.representation.mapper;

import com.douleha.www.application.auth.representation.LoggedRepresentation;
import com.douleha.www.domain.model.user.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by ivan_ on 2015/8/27.
 */
@Component
public class LoggedRepresentationMapper extends CustomMapper<User, LoggedRepresentation> {

    @Override
    public void mapAtoB(User user, LoggedRepresentation loggedRepresentation, MappingContext context) {
        super.mapAtoB(user, loggedRepresentation, context);
    }
}

package com.douleha.www.application.admin.url.representation.mapper;

import com.douleha.www.application.admin.url.representation.AdminUrlRepresentation;
import com.douleha.www.domain.model.url.Url;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;
import org.springframework.stereotype.Component;

/**
 * Created by ivan_ on 2015/9/16.
 */
@Component
public class AdminUrlRepresentationMapper extends CustomMapper<Url, AdminUrlRepresentation> {

    @Override
    public void mapAtoB(Url url, AdminUrlRepresentation adminUrlRepresentation, MappingContext context) {
        super.mapAtoB(url, adminUrlRepresentation, context);
    }
}

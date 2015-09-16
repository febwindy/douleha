package com.douleha.www.domain.service.url;

import com.douleha.www.application.admin.url.command.AdminUrlCommand;
import com.douleha.www.application.admin.url.command.AdminUrlPaginationCommand;
import com.douleha.www.domain.model.url.Url;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/28.
 */
public interface IUrlService {

    void add(AdminUrlCommand command);

    void delete(Integer id);

    void update(AdminUrlCommand command);

    Url findById(Integer id);

    List<Url> pagination(AdminUrlPaginationCommand command);

}

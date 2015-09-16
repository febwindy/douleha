package com.douleha.www.domain.service.url;

import com.douleha.www.application.admin.url.command.AdminUrlCommand;
import com.douleha.www.application.admin.url.command.AdminUrlPaginationCommand;
import com.douleha.www.controller.exception.NotFoundException;
import com.douleha.www.domain.model.url.IUrlRepository;
import com.douleha.www.domain.model.url.Url;
import com.douleha.www.utils.type.api.SqlOperator;
import com.douleha.www.utils.type.model.Disabled;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/28.
 */
@Service("urlService")
public class UrlService implements IUrlService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IUrlRepository urlRepository;

    @Override
    public void add(AdminUrlCommand command) {

        logger.info("创建url");

        Disabled disabled = null;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
        }

        Url url = new Url(
                command.getName(),
                command.getDescription(),
                disabled,
                command.getSort()
        );

        urlRepository.add(url);
    }

    @Override
    public void delete(Integer id) {
        if (0 == urlRepository.delete(id)) {
            throw new NotFoundException("Url's id=[" + id + "]的记录不存在");
        }
    }

    @Override
    public void update(AdminUrlCommand command) {

        logger.info("更新url, id=[{}]", command.getId());

        Disabled disabled = null;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
        }

        Url url = this.findById(command.getId());
        url.setName(command.getName());
        url.setDescription(command.getDescription());
        url.setDisabled(disabled);
        url.setSort(command.getSort());

        urlRepository.update(url);
    }

    @Override
    public Url findById(Integer id) {
        Url url = (Url) urlRepository.findById(id);
        if (null == url) {
            throw new NotFoundException("Url's id=[" + id + "]的记录不存在");
        }
        return url;
    }

    @Override
    public List<Url> pagination(AdminUrlPaginationCommand command) {

        int limitPage = (command.getPage() - 1) * command.getPageSize();
        int limitPageSize = command.getPageSize() * command.getPage();

        Map<String, Object> paramsMap = new HashMap<String, Object>();

        Disabled disabled;
        if (!StringUtils.isEmpty(command.getDisabled())) {
            disabled = Disabled.valueOf(command.getDisabled());
            paramsMap.put("disabled", disabled.getValue());
        }

        if (!StringUtils.isEmpty(command.getName())) {
            paramsMap.put("name", SqlOperator.like(command.getName(), SqlOperator.Like.ANYWHERE));
        }

        paramsMap.put("page", limitPage);
        paramsMap.put("pageSize", limitPageSize);

        return urlRepository.pagination(paramsMap);
    }

}

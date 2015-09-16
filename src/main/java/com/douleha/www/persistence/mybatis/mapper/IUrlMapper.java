package com.douleha.www.persistence.mybatis.mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by ivan_ on 2015/8/28.
 */
public interface IUrlMapper<Url, Integer> extends IMapper<Url, Integer> {

    List<Url> pagination(Map<String, Object> params);

}

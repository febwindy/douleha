package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menutype.IMenuTypeRepository;

/**
 * Created by ivan_ on 2015/8/14.
 */
public class MenuTypeRepository<MenuType, Integer> implements IMenuTypeRepository<MenuType, Integer> {

    @Override
    public MenuType findById(Integer integer) {
        return null;
    }

    @Override
    public int save(MenuType entity) {
        return 0;
    }

    @Override
    public int update(MenuType entity) {
        return 0;
    }

    @Override
    public int delete(MenuType entity) {
        return 0;
    }
}

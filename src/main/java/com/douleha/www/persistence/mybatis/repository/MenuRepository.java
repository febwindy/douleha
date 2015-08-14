package com.douleha.www.persistence.mybatis.repository;

import com.douleha.www.domain.model.menu.IMenuRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Repository("menuRepository")
public class MenuRepository<Menu, Integer> implements IMenuRepository<Menu, Integer> {

    @Override
    public Menu findById(Integer integer) {
        return null;
    }

    @Override
    public int save(Menu entity) {
        return 0;
    }

    @Override
    public int update(Menu entity) {
        return 0;
    }

    @Override
    public int delete(Menu entity) {
        return 0;
    }
}

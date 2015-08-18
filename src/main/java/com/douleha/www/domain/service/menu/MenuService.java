package com.douleha.www.domain.service.menu;

import com.douleha.www.domain.model.menu.IMenuRepository;
import com.douleha.www.domain.model.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Service("menuService")
public class MenuService implements IMenuService {

    @Autowired
    private IMenuRepository menuRepository;

    @Override
    public List<Menu> findAll() {
        return menuRepository.findAll();
    }
}

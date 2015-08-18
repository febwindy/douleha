package com.douleha.www.domain.service.authority;

import com.douleha.www.domain.model.authority.Authority;
import com.douleha.www.domain.model.authority.IAuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/14.
 */
@Service("authorityService")
public class AuthorityService implements IAuthorityService {

    @Autowired
    private IAuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}

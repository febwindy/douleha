package com.douleha.www.utils.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by ivan_ on 2015/8/27.
 * 此内采用单例模式，目的是为了获取orika的MapperFactory对象
 */
public class SingletonMapperFactory {

    private UniqueMapperFactory wrapper;

    public MapperFactory instance() {
        UniqueMapperFactory u = wrapper;
        if (null == u) {
            synchronized (this) {
                u = wrapper;
                if (null == u) {
                    u = new UniqueMapperFactory(new DefaultMapperFactory.Builder().build());
                }
            }
        }
        return u.instance;
    }

    private static class UniqueMapperFactory {

        public final MapperFactory instance;

        private UniqueMapperFactory(MapperFactory instance) {
            this.instance = instance;
        }
    }

}

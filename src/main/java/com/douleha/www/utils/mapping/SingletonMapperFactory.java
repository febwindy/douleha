package com.douleha.www.utils.mapping;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * Created by ivan_ on 2015/8/27.
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

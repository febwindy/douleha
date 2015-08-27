package com.douleha.www.utils.mapping;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ivan_ on 2015/8/27.
 * function:bean copy bean
 */
public class MappingService implements ApplicationContextAware, IMappingService {

    static final private ConcurrentMap<String, BoundMapperFacade> CACHE = new ConcurrentHashMap<String, BoundMapperFacade>(200);

    static final private SingletonMapperFactory SINGLETON_MAPPER_FACTORY = new SingletonMapperFactory();

    @Override
    public <A,B> List<B> mapAsList(List<A> sourceObject, Class<B> destinationClass) {
        return SINGLETON_MAPPER_FACTORY.instance().getMapperFacade().mapAsList(sourceObject, destinationClass);
    }

    @Override
    public <A,B> B map(A sourceObject, Class<B> destinationClass, boolean cycles) {
        BoundMapperFacade<A, B> boundMapperFacade = getMapperFacade(sourceObject, destinationClass, cycles);

        return boundMapperFacade.map(sourceObject);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        final Map<String, Converter> converters = applicationContext.getBeansOfType(Converter.class);
        for (final Converter converter : converters.values()) {
            addConverter(converter);
        }

        final Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
        for (final Mapper mapper : mappers.values()) {
            addMapper(mapper);
        }
    }

    private <A,B> BoundMapperFacade<A,B> getMapperFacade(A sourceObject, Class<B> destinationClass, boolean cycles) {
        Class sourceClass = sourceObject.getClass();
        String key = sourceClass.getName() + destinationClass.getName() + cycles;
        BoundMapperFacade<A,B> boundMapperFacade;
        if (CACHE.containsKey(key)) {
            boundMapperFacade = CACHE.get(key);
        } else {
            BoundMapperFacade<A,B> tmpBoundMapperFacade = SINGLETON_MAPPER_FACTORY.instance()
                    .getMapperFacade(sourceClass, destinationClass, cycles);
            boundMapperFacade = CACHE.putIfAbsent(key, tmpBoundMapperFacade);
            if (boundMapperFacade == null) {
                boundMapperFacade = tmpBoundMapperFacade;
            }
        }
        return boundMapperFacade;
    }

    /**
     * 注册converter
     * @param converter
     */
    public void addConverter(final Converter<?, ?> converter) {
        SINGLETON_MAPPER_FACTORY.instance().getConverterFactory().registerConverter(converter);
    }

    /**
     * 注册mapper
     * @param mapper
     */
    public void addMapper(final Mapper mapper) {
        SINGLETON_MAPPER_FACTORY.instance().classMap(mapper.getAType(), mapper.getBType())
                .byDefault()
                .customize(mapper)
                .register();
    }

}

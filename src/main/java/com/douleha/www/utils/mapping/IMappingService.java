package com.douleha.www.utils.mapping;

import java.util.List;

/**
 * Created by ivan_ on 2015/8/27.
 */
public interface IMappingService {

    <A,B> List<B> mapAsList(List<A> sourceObject, Class<B> destinationClass);

    <A,B> B map(A sourceObject, Class<B> destinationClass, boolean cycles);

}

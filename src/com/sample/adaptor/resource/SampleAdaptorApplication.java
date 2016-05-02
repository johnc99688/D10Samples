package com.sample.adaptor.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.wink.providers.json4j.JSON4JObjectProvider;

public class SampleAdaptorApplication extends Application {
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(SampleAdaptorResource.class);
        classes.add(JSON4JObjectProvider.class);
        return classes;
	}
}

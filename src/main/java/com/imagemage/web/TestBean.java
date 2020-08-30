package com.imagemage.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@ApplicationScope
public class TestBean implements ApplicationContextAware {

    final AtomicInteger counter = new AtomicInteger();

    String applicationName;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationName = applicationContext.getId() + "_" + counter.incrementAndGet();
    }
}

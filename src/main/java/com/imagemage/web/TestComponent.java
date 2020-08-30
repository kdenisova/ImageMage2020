package com.imagemage.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class TestComponent implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TestBean myBean1 = applicationContext.getBean(TestBean.class);
        TestBean myBean2 = applicationContext.getBean(TestBean.class);
        TestBean myBean3 = applicationContext.getBean(TestBean.class);
        TestBean myBean4 = applicationContext.getBean(TestBean.class);
        TestBean myBean5 = applicationContext.getBean(TestBean.class);

        if (myBean1 == myBean2) {
            System.out.println("you're wrong!");
        }
    }
}

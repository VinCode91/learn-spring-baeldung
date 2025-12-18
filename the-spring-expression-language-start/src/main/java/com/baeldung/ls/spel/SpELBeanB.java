package com.baeldung.ls.spel;

import org.springframework.stereotype.Component;

@Component("beanB")
public class SpELBeanB {
    private Integer prop1=10;

    public Integer getProp1() {
        return prop1;
    }

    public boolean compare(int a, int b) {
        return a > b;
    }
}

package com.baeldung.ls.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELBeanA {

    @Value("#{2+3}")
    private Integer add;

    @Value("#{3 > 2 ? 'a' : 'b'}")
    private String ternary;

    @Value("#{beanB.prop1}")
    private String otherBeanProperty;

    @Value("#{beanB.compare(10, 98)}")
    private boolean beanBMethodResult;

    public Integer getAdd() {
        return add;
    }

    public String getTernary() {
        return ternary;
    }

    public String getOtherBeanProperty() {
        return otherBeanProperty;
    }

    public boolean isBeanBMethodResult() {
        return beanBMethodResult;
    }
}

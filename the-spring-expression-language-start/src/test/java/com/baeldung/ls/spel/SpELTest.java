package com.baeldung.ls.spel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
@SpringJUnitConfig({SpELBeanA.class, SpELBeanB.class})
class SpELTest {
    @Autowired
    private SpELBeanA spELBeanA;

    @Autowired
    private SpELBeanB spELBeanB;

    @Test
    public void whenSpELBeanA_thenAllResolvedCorrectly() {
        assertNotNull(spELBeanA);
        assertEquals("a", spELBeanA.getTernary());
        assertEquals(5, spELBeanA.getAdd());
        assertEquals("10", spELBeanA.getOtherBeanProperty());
        assertFalse(spELBeanA.isBeanBMethodResult());
    }
}
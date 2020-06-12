package com.usecase.util.map;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PropertiesTest {

    private Properties buildProperties() {
        Properties props = new Properties();

        props.setProperty("1001", "Java");
        props.setProperty("1002", "Python");
        props.setProperty("1003", "C");
        return props;
    }

    @Test
    public void setProperty() {
        Properties props = buildProperties();
        Object r=props.setProperty("1004", "C++");

        assertEquals(null, r);
        assertEquals(4, props.size());
    }


    @Test
    public void setPropertyDuplicatedKey() {
        Properties props = buildProperties();
        Object r = props.setProperty("1003", "C");

        assertEquals("C", r);
        assertEquals(3, props.size());
    }

    @Test
    public void getProperty() {
        Properties props = buildProperties();
        String r=props.getProperty("1003");

        assertEquals("C", r);
    }

    @Test
    public void getNullProperty() {
        Properties props = buildProperties();
        String r=props.getProperty("1004");

        assertNull(r);
    }
}

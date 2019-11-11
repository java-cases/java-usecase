package com.kenly.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class DemoServiceTest {

    @Autowired
    DemoService demoService;

    @Before
    public void setUp() throws Exception {
        assertNotNull(demoService);
    }

    @Test
    public void getMessage() {
        assertEquals("hello world", demoService.getMessage());
    }
}
package com.usecase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void hello() {
        ResponseEntity<String> entity = template.getForEntity("/emp/hello", String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        System.out.println(entity.getBody());
    }

    @Test
    public void raiseRateLimit() {
        for (int i = 0; i <= 10; i++) {
            template.getForEntity("/emp/limit", String.class);
        }

        for (int i = 0; i <= 10; i++) {
            ResponseEntity<String> entity = template.getForEntity("/emp/limit", String.class);
            ;
            System.out.println(entity.getBody());
            assertEquals(HttpStatus.TOO_MANY_REQUESTS, entity.getStatusCode());
        }
    }

}
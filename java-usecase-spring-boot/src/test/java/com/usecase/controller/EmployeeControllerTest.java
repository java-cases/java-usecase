package com.usecase.controller;

import com.usecase.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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

    @Test
    public void echo() {
        Map<String, String> params = new HashMap<>();
        params.put("something", "say something");

        ResponseEntity<String> entity = template.getForEntity("/emp/echo/{something}",
                String.class, params);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(params.get("something"), entity.getBody());
    }

    @Test
    public void echoParam() {
        Map<String, String> params = new HashMap<>();
        params.put("something", "say something");

        ResponseEntity<String> entity = template.getForEntity("/emp/echo?something={something}",
                String.class, params);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(params.get("something"), entity.getBody());
    }

    @Test
    public void findByIdPathVariable() {
        ResponseEntity<Employee> entity = template.getForEntity("/emp/1", Employee.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        assertNotNull(entity.getBody());
        assertEquals(Integer.valueOf(1), entity.getBody().getId());

        System.out.println(entity.getBody());
    }

    @Test
    public void findByIdPathVariableWithInvalidId() {
        ResponseEntity<Map> entity = template.getForEntity("/emp/-1", Map.class);
        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
    }

    @Test
    public void findByIdParam() {
        Map<String, Integer> params = new HashMap<>();
        params.put("id", 1000);

        ResponseEntity<Employee> entity = template.getForEntity("/emp/get?id={id}", Employee.class, params);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

        assertNotNull(entity.getBody());
        assertEquals(params.get("id"), entity.getBody().getId());

        System.out.println(entity.getBody());
    }
}
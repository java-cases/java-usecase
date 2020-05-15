package com.usecase.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findById() {
        ResponseEntity<Map> entity = restTemplate.getForEntity("/emp/1", Map.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test
    public void findByIdWithInvalidId() {
        ResponseEntity<Map> entity = restTemplate.getForEntity("/emp/-1", Map.class);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test()
    public void echo() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/emp/echo/hello", String.class);

        assertEquals(HttpStatus.OK, entity.getStatusCode());
        System.out.println(entity.getBody());
    }
}
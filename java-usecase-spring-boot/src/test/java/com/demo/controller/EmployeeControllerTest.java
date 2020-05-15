package com.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void findById() {
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/emp/1", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void findByIdWithInvalidId() {
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/emp/-1", Map.class);
        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());
    }

    @Test(expected = RestClientException.class)
    public void echo() {
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/emp/echo/hello", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}
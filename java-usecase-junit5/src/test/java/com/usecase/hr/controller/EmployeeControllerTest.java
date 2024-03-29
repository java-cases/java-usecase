package com.usecase.hr.controller;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findById() {
        ResponseEntity<Map> entity = restTemplate.getForEntity("/emp/1", Map.class);

        assertThat(entity.getStatusCode(), Matchers.is(HttpStatus.OK));
        System.out.println(entity.getBody());
    }

    @Test
    public void findByIdWithInvalidId() {
        ResponseEntity<Map> entity = restTemplate.getForEntity("/emp/-1", Map.class);

        assertThat(entity.getStatusCode(), Matchers.is(HttpStatus.INTERNAL_SERVER_ERROR));
        System.out.println(entity.getBody());
    }

    @Test()
    public void echo() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/emp/echo/hello", String.class);

        assertThat(entity.getStatusCode(), Matchers.is(HttpStatus.OK));
        System.out.println(entity.getBody());
    }
}
package com.usecase.config;

import com.usecase.hr.service.HRService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
class DBSourceConfigTest {

    @Autowired
    private HRService hrService;

    @Test
    void getId() {
        assertThat(hrService.getDBSource().getId(), Matchers.is(1));
    }

    @Test
    void getName() {
    }

    @Test
    void getUri() {
    }
}
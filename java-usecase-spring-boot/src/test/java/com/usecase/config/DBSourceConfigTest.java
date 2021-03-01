package com.usecase.config;

import com.usecase.service.hr.HRService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
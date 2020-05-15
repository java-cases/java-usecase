package com.demo;

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
public class ApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    /* @Test
     public void checkActuatorInfoTest() throws Exception {
         ResponseEntity<Map> entity = testRestTemplate.getForEntity("/actuator", Map.class);
         assertEquals(HttpStatus.OK, entity.getStatusCode());
     }

     @Test
     public void checkApplicationInfoTest() throws Exception {
         ResponseEntity<Map> entity = testRestTemplate.getForEntity("/actuator/info", Map.class);
         assertEquals(HttpStatus.OK, entity.getStatusCode());
     }

     @Test
     public void checkApplicationHealthTest() throws Exception {
         ResponseEntity<Map> entity = testRestTemplate.getForEntity("/actuator/health", Map.class);
         assertEquals(HttpStatus.OK, entity.getStatusCode());
     }
 */

    @Test(expected = RestClientException.class)
    public void echoTest() {
        ResponseEntity<Map> entity = testRestTemplate.getForEntity("/emp/echo/hello", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}

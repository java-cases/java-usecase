package com.usecase.hr.controller;

import com.usecase.customer.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class EmployeeControllerMockMvcTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
        session = new MockHttpSession();

        User user = new User("root", "root");
        session.setAttribute("user", user); //拦截器那边会判断用户是否登录，所以这里注入一个用户
    }

    private MockHttpServletRequestBuilder getRequestBuilder(String url) {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .session(session);
        return requestBuilder;
    }

    @Test
    public void hello() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/hello");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void raiseRateLimit() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/limit");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("limited"))
                .andDo(MockMvcResultHandlers.print());

        for (int i = 0; i <= 10; i++) {
            mvc.perform(requestBuilder);
        }

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isTooManyRequests())
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value("PM.001.002"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void echo() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/echo/{something}").
                param("something", "say something");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("say something"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void echoParam() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/echo").
                param("something", "say something");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("say something"))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void findByIdPathVariable() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/1");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Employee-1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(18))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void findByIdPathVariableWithInvalidId() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/-1");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void findByIdParam() throws Exception {
        RequestBuilder requestBuilder = getRequestBuilder("/emp/get")
                .param("id", "1000");

        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Employee-1000"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(18))
                .andDo(MockMvcResultHandlers.print());
    }

}
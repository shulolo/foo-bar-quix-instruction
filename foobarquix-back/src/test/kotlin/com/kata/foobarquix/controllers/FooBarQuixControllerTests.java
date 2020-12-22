package com.kata.foobarquix.controllers;

import com.kata.foobarquix.FooBarQuixApplicationTests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for FooBarQuixService without starting http server
 */
@AutoConfigureMockMvc
public class FooBarQuixControllerTests extends FooBarQuixApplicationTests {

    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 51, 53, 33, 27, 15})
    public void shouldConvertsInputNumber(int number) throws Exception {

        this.mvc.perform(get("/foo-bar-quix/" + number))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.result", equalTo(getMapTest().get(number))));
    }

}
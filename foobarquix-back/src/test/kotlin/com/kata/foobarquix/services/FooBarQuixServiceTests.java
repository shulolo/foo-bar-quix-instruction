package com.kata.foobarquix.services;

import com.kata.foobarquix.FooBarQuixApplicationTests;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Unit tests for FooBarQuixService
 */
public class FooBarQuixServiceTests extends FooBarQuixApplicationTests {

    @Autowired
    private FooBarQuixService fooBarQuixService;

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9, 51, 53, 33, 27, 15})
    public void shouldConvertsInputNumber(int number) {
        String convertedNumber = fooBarQuixService.convertNumber(number);
        assertThat(convertedNumber).isEqualTo(getMapTest().get(number));
    }
}

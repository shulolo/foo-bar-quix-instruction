package com.kata.foobarquix.services

import org.springframework.stereotype.Component

@Component
class FooBarQuixService {

    /**
     * Converts an input number into a string according to the following rules
     *  - if the number is divisible by 3 or contains 3, replace 3 by "Foo"
     *  - if the number is divisible by 5 or contains 5, replace 5 by "Bar"
     *  - if the number contains 7, replace 7 by "Quix"
     * Divisors have high predecence, the content is analyzed in the order of appearance.
     * If no match, return the input number as a string.
     *
     */
    fun convertNumber(inputNumber: Int): String {
        var result = "";
        // First we check the divisors
        if(inputNumber%3 == 0) {
            result += "Foo";
        }
        if(inputNumber%5 == 0) {
            result += "Bar";
        }

        // Then we check the content in the order of appearance
        for(i in 0 until inputNumber.toString().length) {
            if('3' == inputNumber.toString()[i]) {
                result += "Foo";
            }
            if('5' == inputNumber.toString()[i]) {
                result += "Bar";
            }
            if('7' == inputNumber.toString()[i]) {
                result += "Quix";
            }
        }

        // Finally, we return the result
        if(!result.isEmpty()) return result else return inputNumber.toString();
    }

}
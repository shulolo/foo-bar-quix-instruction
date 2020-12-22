package com.kata.foobarquix

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class FooBarQuixApplicationTests {

    /**
     * Allows to have a static map, which contains input values for testing
     */
    companion object {

        val mapTest: Map<Int, String>

        init {
            val staticMap = HashMap<Int, String>()
            staticMap.put(1, "1")
            staticMap.put(3, "FooFoo")
            staticMap.put(5, "BarBar")
            staticMap.put(7, "Quix")
            staticMap.put(9, "Foo")
            staticMap.put(51, "FooBar")
            staticMap.put(53, "BarFoo")
            staticMap.put(33, "FooFooFoo")
            staticMap.put(27, "FooQuix")
            staticMap.put(15, "FooBarBar")
            mapTest = Collections.unmodifiableMap(staticMap)
        }
    }

	@Test
	fun contextLoads() {
	}

    /**
     * Return the map containing input values for the subclasses
     */
    fun getMapTest(): Map<Int, String> {
        return mapTest;
    }

}

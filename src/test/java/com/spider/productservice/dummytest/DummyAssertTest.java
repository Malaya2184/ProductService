package com.spider.productservice.dummytest;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DummyAssertTest {

    @Test
    void testAssertTrue() {
        boolean condition = true;
        assertTrue(condition, "The condition should be true");
    }

    @Test
    void testAssertFalse() {
        boolean condition = false;
        assertFalse(condition, "The condition should be false");
    }

    @Test
    void testAssertEquals() {
        int expected = 5;
        int actual = 2 + 3;
        assertEquals(expected, actual, "The expected and actual values should be equal");
    }

    @Test
    void testAssertNotEquals() {
        int expected = 5;
        int actual = 6;
        assertNotEquals(expected, actual, "The expected and actual values should not be equal");
    }

    @Test
    void testAssertNull() {
        Object obj = null;
        assertNull(obj, "The object should be null");
    }

    @Test
    void testAssertNotNull() {
        Object obj = new Object();
        assertNotNull(obj, "The object should not be null");
    }

    @Test
    void testAssertSame() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame(obj1, obj2, "The two objects should be the same");
    }

    @Test
    void testAssertNotSame() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1, obj2, "The two objects should not be the same");
    }

    @Test
    void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual, "The expected and actual arrays should be equal");
    }

    @Test
    void testAssertLinesMatch() {
        String expected = "Line 1\nLine 2\nLine 3";
        String actual = "Line 1\nLine 2\nLine 3";
        assertLinesMatch(Collections.singletonList(expected), Collections.singletonList(actual), "The expected and actual lines should match");
    }
}
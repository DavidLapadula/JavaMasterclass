package com.davidlapadula;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private Utilities util;

    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        util = new Utilities();
        char[] output = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e', 'l'}, output);
        char[] output2 = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.Test
    public void removePairs() {
        util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("A", util.removePairs("A"));
        assertNull(null, util.removePairs(null));
    }

    @org.junit.Test
    public void converter() {
        util = new Utilities();
        assertEquals(300, util.converter(10, 5 ));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_arithmeticexception() throws Exception {
        util = new Utilities();
        assertEquals(300, util.converter(10, 0 ));
    }


    @org.junit.Test
    public void nullIfOddLength() {
        util = new Utilities();
        assertNull(util.nullIfOddLength("odd"));
        assertNotNull(util.nullIfOddLength("even"));
    }
}
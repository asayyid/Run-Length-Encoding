package com.github.asayyid.rle;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for RunLengthEncoder
 * Contains various test cases to verify the encoding functionality is working as expected
 */
class RunLengthEncoderTest {

    private RunLengthEncoder encoder;

    @BeforeEach
    void setUp() {
        encoder = new RunLengthEncoder();
    }

    @Test
    @DisplayName("Test encoding with empty string")
    void testEncodeEmptyString() {
        assertEquals("", encoder.encode(""));
    }

    @Test
    @DisplayName("Test encoding with null input")
    void testEncodeNullInput() {
        assertThrows(IllegalArgumentException.class, () -> encoder.encode(null));
    }

    @Test
    @DisplayName("Test encoding with all whitespaces")
    void testEncodeSpaceInput() {
        assertEquals(" 3", encoder.encode("   "));
    }

    @Test
    @DisplayName("Test encoding with example from problem statement")
    void testEncodeProblemExample() {
        assertEquals("w4a3d1e1x6", encoder.encode("wwwwaaadexxxxxx"));
    }

    @Test
    @DisplayName("Test encoding with repeated characters")
    void testEncodeRepeatedCharacters() {
        assertEquals("a4b3c3", encoder.encode("aaaabbbccc"));
    }

    @Test
    @DisplayName("Test encoding with single char multiple occurrences")
    void testEncodeSingleOccurrences() {
        assertEquals("a10", encoder.encode("aaaaaaaaaa"));
    }

    @Test
    @DisplayName("Test encoding with multiple char single occurrences")
    void testEncodeMultiCharSingleOccurrences() {
        assertEquals("a1b1c1d1e1", encoder.encode("abcde"));
    }

    @Test
    @DisplayName("Test encoding with single character")
    void testEncodeSingleCharacter() {
        assertEquals("a1", encoder.encode("a"));
    }

    @Test
    @DisplayName("Test encoding with special characters")
    void testEncodeSpecialCharacters() {
        assertEquals("!2@3#1", encoder.encode("!!@@@#"));
    }

    @Test
    @DisplayName("Test encoding with numbers")
    void testEncodeNumbers() {
        assertEquals("122333", encoder.encode("11222333"));
    }


    @ParameterizedTest
    @CsvSource({
            "aaa,a3",
            "-__,-1_2",
            "aabbcc,a2b2c2",
    })
    @DisplayName("Test encoding with various input patterns")
    void testEncodeVariousPatterns(String input, String expected) {
        assertEquals(expected, encoder.encode(input));
    }
}
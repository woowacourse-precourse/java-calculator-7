package calculator.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PreprocessingTest {
    @Test
    void testFirstLetter_withCustomSeparator() {
        Preprocessing preprocessing = new Preprocessing();
        assertTrue(preprocessing.firstLetter("//;\n1;2"));
    }

    @Test
    void testFirstLetter_withNoCustomSeparator() {
        Preprocessing preprocessing = new Preprocessing();
        assertFalse(preprocessing.firstLetter("1,2:3"));
    }

    @Test
    void testSeparation() {
        Preprocessing preprocessing = new Preprocessing();
        List<String> result = preprocessing.separation("1,2:3", Arrays.asList(",", ":"));
        assertEquals(Arrays.asList("1", ",", "2", ":", "3"), result);
    }

    @Test
    void testFindCustomSeparator() {
        Preprocessing preprocessing = new Preprocessing();
        List<String> result = preprocessing.findCustomSeparator("//;\n1;2");
        assertEquals(Arrays.asList(";", "1;2"), result);
    }
}

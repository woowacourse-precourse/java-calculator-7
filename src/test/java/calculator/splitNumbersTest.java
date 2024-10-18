package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SplitNumbersTest {

    @Test
    void testSplitNumsWithCustomDelimiter() {
        String input = "//;\n1;2;3";
        String custom = ";";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        assertEquals(expected, splitNumbers.splitNums(input, custom));
    }

    @Test
    void testSplitNumsWithCommaAndColon() {
        String input = "1,2:3";
        String custom = "";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        assertEquals(expected, splitNumbers.splitNums(input, custom));
    }

    @Test
    void testSplitNumsWithMultipleDelimiters() {
        String input = "//#\n1#2,3:4";
        String custom = "#";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        assertEquals(expected, splitNumbers.splitNums(input, custom));
    }

    @Test
    void testSplitNumsWithNoCustomDelimiter() {
        String input = "1:2,3";
        String custom = "";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        assertEquals(expected, splitNumbers.splitNums(input, custom));
    }

    @Test
    void testSplitNumsWithInvalidFormat() {
        String input = "1,2,3"; // "//"나 "\n"이 없어도 동작
        String custom = "";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        assertEquals(expected, splitNumbers.splitNums(input, custom));
    }

    @Test
    void testSplitNumsIsNone() {
        String input = "";
        String custom = "";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(""));
        assertEquals(expected, splitNumbers.splitNums(input, custom));
    }
}
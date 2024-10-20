package calculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExtractDelimitersTest {

    @Test
    void testExtractSingleCustomDelimiter() {
        String input = "//;\n1;2,3";
        List<String> delimiters = ExtractDelimiters.extractDelimiters(input);
        assertEquals(3, delimiters.size());
        assertEquals(";", delimiters.get(0)); // 커스텀 구분자
        assertEquals(",", delimiters.get(1)); // 기본 구분자
        assertEquals(":", delimiters.get(2)); // 기본 구분자
    }

    @Test
    void testExtractMultipleCustomDelimiters() {
        String input = "//;\n//a\n1;2:3";
        List<String> delimiters = ExtractDelimiters.extractDelimiters(input);
        assertEquals(4, delimiters.size());
        assertEquals(";", delimiters.get(0)); // 첫 번째 커스텀 구분자
        assertEquals("a", delimiters.get(1)); // 두 번째 커스텀 구분자
        assertEquals(",", delimiters.get(2)); // 기본 구분자
        assertEquals(":", delimiters.get(3)); // 기본 구분자
    }

    @Test
    void testExtractNoCustomDelimiter() {
        String input = "1,2:3";
        List<String> delimiters = ExtractDelimiters.extractDelimiters(input);
        assertEquals(2, delimiters.size());
        assertEquals(",", delimiters.get(0)); // 기본 구분자
        assertEquals(":", delimiters.get(1)); // 기본 구분자
    }

    @Test
    void testExtractEmptyInput() {
        String input = "";
        List<String> delimiters = ExtractDelimiters.extractDelimiters(input);
        assertEquals(2, delimiters.size());
        assertEquals(",", delimiters.get(0)); // 기본 구분자
        assertEquals(":", delimiters.get(1)); // 기본 구분자
    }

    @Test
    void testExtractSingleCustomDelimiterNoNumbers() {
        String input = "//;\n";
        List<String> delimiters = ExtractDelimiters.extractDelimiters(input);
        assertEquals(3, delimiters.size());
        assertEquals(";", delimiters.get(0)); // 커스텀 구분자
        assertEquals(",", delimiters.get(1)); // 기본 구분자
        assertEquals(":", delimiters.get(2)); // 기본 구분자
    }
}
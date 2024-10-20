package calculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class findDelimiterTest {

    @Test
    void testFindDelimiterWithValidDelimiter() {
        String input = "1;2:3";
        List<String> delimiters = Arrays.asList(";", ":");
        int index = 1; // 위치 1에서 찾기 시작
        String result = findDelimiter.findDelimiter(input, index, delimiters);
        assertEquals(";", result); // 위치 1에서 ';'를 찾아야 함
    }

    @Test
    void testFindDelimiterWithAnotherValidDelimiter() {
        String input = "1;2:3";
        List<String> delimiters = Arrays.asList(";", ":");
        int index = 3; // 위치 3에서 찾기 시작
        String result = findDelimiter.findDelimiter(input, index, delimiters);
        assertEquals(":", result); // 위치 3에서 ':'를 찾아야 함
    }

    @Test
    void testFindDelimiterWithInvalidIndex() {
        String input = "1;2:3";
        List<String> delimiters = Arrays.asList(";", ":");
        int index = 0; // 위치 0에서 찾기 시작
        String result = findDelimiter.findDelimiter(input, index, delimiters);
        assertEquals(null, result); // 위치 0에서 ';'를 찾아야 함
    }

    @Test
    void testFindDelimiterWithNoDelimiterFound() {
        String input = "123456";
        List<String> delimiters = Arrays.asList(";", ":");
        int index = 0; // 위치 0에서 찾기 시작
        String result = findDelimiter.findDelimiter(input, index, delimiters);
        assertEquals(null, result); // 구분자가 없으므로 null 반환
    }

    @Test
    void testFindDelimiterWithEmptyInput() {
        String input = "";
        List<String> delimiters = Arrays.asList(";", ":");
        int index = 0; // 위치 0에서 찾기 시작
        String result = findDelimiter.findDelimiter(input, index, delimiters);
        assertEquals(null, result); // 빈 문자열에서 구분자를 찾을 수 없음
    }

    @Test
    void testFindDelimiterWithOnlyDelimiters() {
        String input = ";:";
        List<String> delimiters = Arrays.asList(";", ":");
        int index = 0; // 위치 0에서 찾기 시작
        String result = findDelimiter.findDelimiter(input, index, delimiters);
        assertEquals(";", result); // 위치 0에서 ';'를 찾아야 함
    }
}
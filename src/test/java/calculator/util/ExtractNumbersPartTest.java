package calculator.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ExtractNumbersPartTest {

    @Test
    void testExtractNumbersPartWithCustomDelimiter() {
        String input = "//;\\n1;2;3";
        String result = ExtractNumbersPart.extractNumbersPart(input);
        assertEquals("1;2;3", result); // 커스텀 구분자 사용 시 숫자 부분
    }

    @Test
    void testExtractNumbersPartWithMultipleCustomDelimiters() {
        String input = "//;\\n//:\\n1;2:3";
        String result = ExtractNumbersPart.extractNumbersPart(input);
        assertEquals("1;2:3", result); // 여러 커스텀 구분자를 사용할 경우
    }

    @Test
    void testExtractNumbersPartWithoutCustomDelimiter() {
        String input = "1,2,3";
        String result = ExtractNumbersPart.extractNumbersPart(input);
        assertEquals("1,2,3", result); // 기본 구분자만 있는 경우
    }

    @Test
    void testExtractNumbersPartWithEmptyInput() {
        String input = "";
        String result = ExtractNumbersPart.extractNumbersPart(input);
        assertEquals("", result); // 빈 문자열인 경우
    }

    @Test
    void testExtractNumbersPartWithOnlyCustomDelimiter() {
        String input = "//;\\n";
        String result = ExtractNumbersPart.extractNumbersPart(input);
        assertEquals("", result); // 커스텀 구분자만 있는 경우
    }

    @Test
    void testExtractNumbersPartWithWhitespace() {
        String input = "   //;\\n   1; 2; 3  ";
        String result = ExtractNumbersPart.extractNumbersPart(input);
        assertEquals("1; 2; 3", result.trim()); // 공백이 포함된 경우
    }
}
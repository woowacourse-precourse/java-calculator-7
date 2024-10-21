package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberParserTest {
    private NumberParser numberParser;
    private String inputString;

    @Test
    void testBasicDelimiters() {
        // 기본 구분자(콤마, 콜론)로 숫자 추출
        NumberParser parser = new NumberParser("1,2:3");
        List<Integer> numbers = parser.getExtractedNumList();
        assertEquals(3, numbers.size());
        assertEquals(List.of(1, 2, 3), numbers);
    }

    @Test
    void testCustomDelimiterSingleCharacter() {
        // 단일 커스텀 구분자
        NumberParser parser = new NumberParser("//;\\n1;2;3");
        List<Integer> numbers = parser.getExtractedNumList();
        assertEquals(3, numbers.size());
        assertEquals(List.of(1, 2, 3), numbers);
    }

    @Test
    void testCustomDelimiterMultipleCharacters() {
        // 여러 문자로 구성된 커스텀 구분자
        NumberParser parser = new NumberParser("//***\\n1***2***3");
        List<Integer> numbers = parser.getExtractedNumList();
        assertEquals(3, numbers.size());
        assertEquals(List.of(1, 2, 3), numbers);
    }

    @Test
    void testInvalidFormatMissingNewLine() {
        // 잘못된 입력 형식: "\n"이 없음
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new NumberParser("//***1***2***3");
        });
        assertEquals("유효하지 않은 구분자 형식입니다.", exception.getMessage());
    }

    @Test
    void testNullInput() {
        // null 입력에 대한 예외 발생 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new NumberParser(null);
        });
        assertEquals("입력이 비어있습니다.", exception.getMessage());
    }

    @Test
    void testEmptyInput() {
        // 빈 문자열에 대한 예외 발생 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new NumberParser("");
        });
        assertEquals("입력이 비어있습니다.", exception.getMessage());
    }

    @Test
    void testInvalidNumber() {
        // 숫자가 아닌 값이 있을 경우
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new NumberParser("1,2,three");
        });
        assertEquals("숫자가 아닌 값이 있습니다: three", exception.getMessage());
    }

    @Test
    void testMixedDelimiters() {
        // 기본 구분자와 커스텀 구분자를 함께 사용
        NumberParser parser = new NumberParser("//;\\n1,2;3:4");
        List<Integer> numbers = parser.getExtractedNumList();
        assertEquals(4, numbers.size());
        assertEquals(List.of(1, 2, 3, 4), numbers);
    }
}

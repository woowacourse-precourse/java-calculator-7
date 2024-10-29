package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ParsingServiceTest {
    private final ParsingService parser = new ParsingService();

    @Test
    void 기본_구분자_검증() {

        // 예상 결과
        List<String> expected = Arrays.asList("1", "2", "3");

        // 실제 결과
        List<String> result = parser.stringParse("1,2:3");

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_검증() {

        // 예상 결과
        List<String> expected = Arrays.asList("1", "2", "3");

        // 실제 결과
        List<String> result = parser.stringParse("//;\\n1;2;3");

        /// 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_및_기본_구분자_혼용_검증() {

        // 예상 결과
        List<String> expected = Arrays.asList("1", "2", "3", "4");

        // 실제 결과
        List<String> result = parser.stringParse("//;\\n1;2,3;4");

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_특수문자_검증() {

        // 예상 결과
        List<String> expected = Arrays.asList("1", "2", "3");

        // 실제 결과
        List<String> result = parser.stringParse("//|\\n1|2|3");

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 빈_문자열_검증() {

        // 예상 결과
        List<String> expected = List.of("");

        // 실제 결과
        List<String> result = parser.stringParse("");

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 커스텀_구분자_빈문자열_검증() {

        // 예상 결과
        List<String> expected = List.of("");

        // 실제 결과
        List<String> result = parser.stringParse("//;\\n");

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }
}

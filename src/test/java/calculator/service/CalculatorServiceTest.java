package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private final CalculatorService calculator = new CalculatorService();

    @Test
    void 문자열_덧셈_기본() {
        List<String> numbers = Arrays.asList("1", "2", "3");

        // 예상 결과
        String expected = "6";

        // 실제 결과
        String result = calculator.add(numbers);

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 문자열_덧셈_큰_숫자() {
        List<String> numbers = Arrays.asList("123456789876543212345678987654321", "123456789876543212345678987654321",
                "123456789876543212345678987654321");

        // 예상 결과
        String expected = "370370369629629637037036962962963";

        // 실제 결과
        String result = calculator.add(numbers);

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 문자열_덧셈_올림수() {
        List<String> numbers = Arrays.asList("1", "999");

        // 예상 결과
        String expected = "1000";

        // 실제 결과
        String result = calculator.add(numbers);

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 문자열_덧셈_빈_문자열() {
        List<String> numbers = Arrays.asList("", "1");

        // 예상 결과
        String expected = "1";

        // 실제 결과
        String result = calculator.add(numbers);

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }

    @Test
    void 문자열_덧셈_0() {
        List<String> numbers = Arrays.asList("0", "1", "0");

        // 예상 결과
        String expected = "1";

        // 실제 결과
        String result = calculator.add(numbers);

        // 예상 결과와 실제 결과 비교
        assertEquals(expected, result);
    }
}

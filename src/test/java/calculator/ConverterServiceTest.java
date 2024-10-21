package calculator;

import static calculator.exception.Exception.INVALID_NEGATIVE_NUMBER;
import static calculator.exception.Exception.INVALID_NUMBER_FORMAT;
import static org.junit.jupiter.api.Assertions.*;

import calculator.service.ConverterService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ConverterServiceTest {

    @Test
    void shouldThrowExceptionForInvalidCharacterInInput() {
        ConverterService converterService = new ConverterService();

        // 유효하지 않은 문자가 포함된 입력
        List<String> input = Arrays.asList("1", "2", "abc", "4");

        // 유효하지 않은 문자가 포함되어 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                converterService.toNumbers(input));

        assertEquals(INVALID_NUMBER_FORMAT.getMessage() + "abc", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNegativeNumbersInInput() {
        ConverterService converterService = new ConverterService();

        // 음수가 포함된 입력
        List<String> input = Arrays.asList("1", "-2", "3", "4");

        // 음수가 포함되어 있을 때 예외가 발생하는지 확인
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                converterService.toNumbers(input));

        assertEquals(INVALID_NEGATIVE_NUMBER.getMessage() + "-2", exception.getMessage());
    }

    @Test
    void shouldConvertValidStringInputsToIntegerList() {
        ConverterService converterService = new ConverterService();

        // 적절한 입력
        List<String> input = Arrays.asList("1", "2", "3", "4");

        // 입력을 Integer 리스트로 변환
        List<Integer> result = converterService.toNumbers(input);

        // 결과 확인
        assertEquals(4, result.size(), "정수 4개가 포함되어야 합니다.");
        assertEquals(1, result.get(0));
        assertEquals(2, result.get(1));
        assertEquals(3, result.get(2));
        assertEquals(4, result.get(3));
    }
}

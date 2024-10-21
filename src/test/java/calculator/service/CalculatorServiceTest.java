package calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("문자열을 쉼표와 콜론으로 구분한다")
    void splitByCommaAndColon() {
        //given
        String input = "1,2:3";

        //when
        List<String> result = calculatorService.splitByDelimiters(input);

        //then
        assertEquals(3L, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
    }

    @Test
    @DisplayName("문자열을 커스텀 구분자로 구분한다")
    void splitByCustomDelimiter() {
        //given
        String input = "//;\\n1;2,3:4;5";

        //when
        List<String> result = calculatorService.splitByDelimiters(input);

        //then
        assertEquals(5L, result.size());
        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("3", result.get(2));
        assertEquals("4", result.get(3));
        assertEquals("5", result.get(4));
    }

    @Test
    @DisplayName("구분한 숫자의 합을 구한다")
    void calculateSumOfSplitNumbers() {
        //given
        String input = "//;\\n1;2,3:4;5";
        List<String> splitInput = calculatorService.splitByDelimiters(input);

        //when
        long sum = calculatorService.sum(splitInput);

        //then
        assertEquals(15L, sum);
    }

    @Test
    @DisplayName("구분된 문자에 음수가 포함되면 예외가 발생한다")
    void throwExceptionWhenNegativeNumberIncluded() {
        //given
        String input = "1,-2:3";

        //expected
        assertThrows(IllegalArgumentException.class, () ->
                calculatorService.splitByDelimiters(input));
    }

    @Test
    @DisplayName("구분된 문자에 0이 포함되면 예외가 발생한다")
    void throwExceptionWhenZeroIncluded() {
        //given
        String input = "1,2:0";

        //expected
        assertThrows(IllegalArgumentException.class, () ->
                calculatorService.splitByDelimiters(input));
    }

    @Test
    @DisplayName("구분된 문자에 문자가 포함되면 예외가 발생한다")
    void throwExceptionWhenNonNumericCharacterIncluded() {
        //given
        String input = "A,2:3";

        //expected
        assertThrows(IllegalArgumentException.class, () ->
                calculatorService.splitByDelimiters(input));
    }

    @Test
    @DisplayName("구분된 문자에 공백이 포함되면 예외가 발생한다")
    void throwExceptionWhenEmptyCharacterIncluded() {
        //given
        String input = "A,:3";

        //expected
        assertThrows(IllegalArgumentException.class, () ->
                calculatorService.splitByDelimiters(input));
    }

    @Test
    @DisplayName("빈 문자열이 입력되면 0을 반환한다")
    void returnZeroForEmptyInput() {
        //given
        String input = "";
        List<String> list = calculatorService.splitByDelimiters(input);

        //when
        long sum = calculatorService.sum(list);

        //then
        assertEquals(0, sum);
    }

    @Test
    @DisplayName("엄청 큰 숫자도 long 범위 내에서 합산된다")
    void sumBigNumbersWithinLongRange() {
        //given
        String input = "1000000000000000000,2000000000000000000:3000000000000000000";
        List<String> splitInput = calculatorService.splitByDelimiters(input);

        //when
        long sum = calculatorService.sum(splitInput);

        //then
        assertEquals(6000000000000000000L, sum);
    }

    @Test
    @DisplayName("구분자가 잘못된 형식일 때 예외가 발생한다")
    void throwExceptionForInvalidCustomDelimiter() {
        //given
        String input = "//\\n1;2,3:4";

        //expected
        assertThrows(IllegalArgumentException.class, () ->
                calculatorService.splitByDelimiters(input));
    }
}
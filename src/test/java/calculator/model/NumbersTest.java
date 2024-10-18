package calculator.model;

import calculator.controller.CalculatorController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("숫자 확인")
class NumbersTest {
    @ParameterizedTest(name = "{index} : {2}")
    @DisplayName("숫자 개수 확인")
    @MethodSource("generateData")
    void testNumberCount(String input, int output, String message) {
        List<Integer> numbers = new CalculatorController().getNumbers(input);
        assertThat(numbers.size()).isEqualTo(output);
    } // testNumberCount

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("//;\\n1;2;3", 3, "커스텀 구분자로 구분"),
                Arguments.of("1,2:3,4", 4, "기본 구분자로 구분")
        );
    } // generateData

    @Test
    @DisplayName("양수 확인")
    void isPositive() {
        Numbers numbers = new Numbers(new CustomSeparator().separate("//-\\n-1-2--3"));
        assertThat(numbers.getNumbers().stream().allMatch(number -> number >= 0)).isTrue();
    } // isPositive
} // class
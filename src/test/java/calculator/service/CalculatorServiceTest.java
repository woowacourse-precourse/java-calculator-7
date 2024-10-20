package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterExtractor;
import calculator.domain.NumberExtractor;
import calculator.domain.StringSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {
    @DisplayName("사용자가 입력한 문자열이 비어있으면 0을 반환한다.")
    @Test
    void returnZeroWhenUserPutEmptyValue() {
        //given
        String stringToAdd = "";
        CalculatorService calculatorService = createCalculatorService();
        //when
        int sum = calculatorService.calculateSum(stringToAdd);
        //then
        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("사용자가 입력한 커스텀구분자와 기존 구분자들로 숫자 합을 구할 수 있다.")
    @Test
    void getSumWithCustomAndOriginalDelimiters() {
        //given
        String stringToAdd = "//;\\n1;2:3,4,5";
        CalculatorService calculatorService = createCalculatorService();
        //when
        int sum = calculatorService.calculateSum(stringToAdd);
        //then
        assertThat(sum).isEqualTo(15);
    }

    @DisplayName("기존 구분자들로 사용자가 입력한 문자열의 숫자 합을 구할 수 있다.")
    @Test
    void getSumWithOriginalDelimiters() {
        //given
        String stringToAdd = "10,2:8";
        CalculatorService calculatorService = createCalculatorService();
        //when
        int sum = calculatorService.calculateSum(stringToAdd);
        //then
        assertThat(sum).isEqualTo(20);
    }

    @DisplayName("사용자가 입력한 커스텀구분자로 숫자 합을 구할 수 있다.")
    @Test
    void getSumWithCustomDelimiter() {
        //given
        String stringToAdd = "//d\\n1d2d3d4d";
        CalculatorService calculatorService = createCalculatorService();
        //when
        int sum = calculatorService.calculateSum(stringToAdd);
        //then
        assertThat(sum).isEqualTo(10);
    }

    @DisplayName("사용자가 입력한 커스텀구분자로 숫자 합을 구할 수 있다.")
    @Test
    void getSumWithCustomDelimiter2() {
        //given
        String stringToAdd = "//구분\\n1구분2구분3구분4";
        CalculatorService calculatorService = createCalculatorService();
        //when
        int sum = calculatorService.calculateSum(stringToAdd);
        //then
        assertThat(sum).isEqualTo(10);
    }

    private CalculatorService createCalculatorService() {
        Calculator calculator = new Calculator();
        NumberExtractor numberExtractor = new NumberExtractor(new StringSplitter(
                new CustomDelimiterExtractor()));

        return new CalculatorService(calculator, numberExtractor);
    }

}
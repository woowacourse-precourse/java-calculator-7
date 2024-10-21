package calculator.service;

import calculator.domain.Calculator;
import calculator.domain.CustomDelimiterExtractor;
import calculator.domain.NumberExtractor;
import calculator.domain.StringSplitter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
        NumberExtractor numberExtractor = new NumberExtractor(new StringSplitter(
                new CustomDelimiterExtractor()));

        calculatorService = new CalculatorService(calculator, numberExtractor);
    }

    @DisplayName("사용자가 입력한 문자열이 비어있으면 0을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "\t", "\n"})
    void returnZeroWhenUserPutEmptyValue(String input) {
        //given
        //when
        int sum = calculatorService.calculateSum(input);
        //then
        assertThat(sum).isEqualTo(0);
    }

    @DisplayName("사용자가 입력한 커스텀구분자와 기존 구분자들로 숫자 합을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2:3,4,5-15", "//+\\n01:02+03,04-10"}, delimiter = '-')
    void getSumWithCustomAndOriginalDelimiters(String input, int expectedSum) {
        //given
        //when
        int sum = calculatorService.calculateSum(input);
        //then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName("기존 구분자들로 사용자가 입력한 문자열의 숫자 합을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"10,2:8-20", "1,2,3:4:5:6:7,8,9:10-55"}, delimiter = '-')
    void getSumWithOriginalDelimiters(String input, int expectedSum) {
        //given
        //when
        int sum = calculatorService.calculateSum(input);
        //then
        assertThat(sum).isEqualTo(expectedSum);
    }

    @DisplayName("사용자가 입력한 커스텀구분자로 숫자 합을 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"//d\\n1d2d3d4d,10", "//구분\\n12구분24구분10구분4,50", "//-\\n10-20-30-40,100"})
    void getSumWithCustomDelimiter(String input, int expectedSum) {
        //given
        //when
        int sum = calculatorService.calculateSum(input);
        //then
        assertThat(sum).isEqualTo(expectedSum);
    }
}
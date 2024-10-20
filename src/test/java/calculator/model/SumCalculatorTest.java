package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("덧셈 계산 테스트")
class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @ParameterizedTest
    @CsvSource({"'1,2:3:4',10", "'',0", "'500',500"})
    @DisplayName("기본 구분자를 사용할 때 덧셈 연산을 정확하게 수행한다")
    void calculateSumExactlyWithDefaultDelimiter(String input, int expected) {
        InputData inputData = new InputData(input);
        assertThat(sumCalculator.calculate(new Arithmetic(new DefaultDelimiter(), inputData)))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"'//;.\\n1;2,3,4',10", "'//!\\n',0", "'//!\\n500',500"})
    @DisplayName("커스텀 구분자를 사용할 때 덧셈 연산을 정확하게 수행한다")
    void calculateSumExactlyWithCustomDelimiter(String input, int expected) {
        InputData inputData = new InputData(input);
        assertThat(sumCalculator.calculate(new Arithmetic(new CustomDelimiter(inputData.convertDelimiterPart()), inputData)))
                .isEqualTo(expected);
    }
}
package calculator.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@DisplayName("덧셈 계산 테스트")
class SumCalculatorTest {
    private SumCalculator sumCalculator;

    @BeforeEach
    void setUp() {
        sumCalculator = new SumCalculator();
    }

    @Test
    @DisplayName("기본 구분자를 사용할 때 덧셈 연산을 정확하게 수행한다")
    void calculateSumExactlyWithDefaultDelimiter(){
        InputData inputData = new InputData("1,2,3,4");
        assertThat(sumCalculator.calculate(new Arithmetic(new DefaultDelimiter(),inputData)))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할 때 덧셈 연산을 정확하게 수행한다")
    void calculateSumExactlyWithCustomDelimiter(){
        InputData inputData = new InputData("//;.\\n1;2,3,4");
        assertThat(sumCalculator.calculate(new Arithmetic(new CustomDelimiter(inputData.convertDelimiterPart()),inputData)))
                .isEqualTo(10);
    }
}
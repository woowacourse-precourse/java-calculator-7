package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("기본 구분자(:), 커스텀 구분자(;*~)를 이용해서 입력했을 시 덧셈 결과값을 반환하는지 테스트하라")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            INPUT,         EXPECTED
            1:2:3,         6
            //;\\n1;2;3,   6
            //*\\n1*2*3,   6
            //~\\n1~2~3,   6
    """)
    void test_calculate(String input, int expected) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        int result = stringAddCalculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("기본 구분자(,)를 이용해서 입력했을 시 덧셈 결과값을 반환하는지 테스트하라")
    @Test
    void test_calculate_with_default_delimiter() {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();

        int result = stringAddCalculator.calculate("1,2,3");

        assertThat(result).isEqualTo(6);
    }
}

package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator;

    public StringAddCalculatorTest() {
        this.stringAddCalculator = new StringAddCalculator(new InputParser(new Delimiter()),new Calculator());
    }

    @Test
    void 문자열이_null_인경우() {
        // given
        final String str = null;

        // when
        int resultNull = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(resultNull).isEqualTo(0);
    }

    @Test
    void 문자열이_빈문자열인경우() {
        // given
        final String str = "";

        // when
        int resultEmpty = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(resultEmpty).isEqualTo(0);
    }

    @Test
    void 정상적인_문자열을_받은경우() {
        // given
        final String str = "1,2:3";

        // when
        int result = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_존재할경우() {
        // given
        final String str = "//;\n1;2;3";

        // when
        int result = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 값이_잘못되었다면_예외처리() {
        // given
        final String str = "t,2,3";

        // when & then
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum(str);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

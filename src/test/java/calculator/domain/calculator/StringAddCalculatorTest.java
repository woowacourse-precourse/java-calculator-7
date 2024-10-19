package calculator.domain.calculator;

import calculator.domain.delimiter.Delimiters;
import calculator.domain.input.InputParser;
import calculator.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator;

    public StringAddCalculatorTest() {
        this.stringAddCalculator = new StringAddCalculator(new InputParser(new Delimiters()),new Calculator());
    }

    @Test
    void 문자열이_null_인경우_0을반환함() {
        // given
        final String str = null;

        // when
        int resultNull = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(resultNull).isEqualTo(0);
    }

    @Test
    void 문자열이_빈문자열인경우_0을반환함() {
        // given
        final String str = "";

        // when
        int resultEmpty = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(resultEmpty).isEqualTo(0);
    }

    @Test
    void 정상적인_문자열을_받은경우_모두_더한_합_반환() {
        // given
        final String str = "1,2:3";

        // when
        int result = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_존재할경우_커스텀_구분자로_문자를나눔() {
        // given
        final String str = "//;\n1;2;3";

        // when
        int result = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_존재할경우_커스텀_구분자도_포함하여_문자를나눔() {
        // given
        final String str = "//;\n1;2;3,4:5";

        // when
        int result = stringAddCalculator.splitAndSum(str);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 값이_잘못되었다면_예외처리_IllegalArgumentException() {
        // given
        final String str = "t,2,3";

        // when & then
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum(str);
        }).isInstanceOf(BusinessException
                .class);
    }
}

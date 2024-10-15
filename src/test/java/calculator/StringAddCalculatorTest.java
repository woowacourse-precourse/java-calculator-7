package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    void 문자열이_null또는_비어있을경우() {
        int resultNull = StringAddCalculator.splitAndSum(null);
        assertThat(resultNull).isEqualTo(0);

        int resultEmpty = StringAddCalculator.splitAndSum("");
        assertThat(resultEmpty).isEqualTo(0);
    }

    @Test
    void 정상적인_문자열을_받은경우() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_존재할경우() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_체크_테스트() {
        String delimiter = StringAddCalculator.checkCustomDelimiter("//;\n1;2;3");
        assertThat(delimiter).isEqualTo(";");
    }

    @Test
    void 값이_잘못되었다면_예외처리() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("t,2,3")).isInstanceOf(IllegalArgumentException.class);
    }
}

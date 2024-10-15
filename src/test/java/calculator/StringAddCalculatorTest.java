package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}

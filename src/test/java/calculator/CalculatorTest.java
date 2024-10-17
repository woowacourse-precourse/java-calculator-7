package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class CalculatorTest {
    @Test
    void 기본_합치기_테스트() {
        //given
        final Calculator calculator = new Calculator();
        final String str = "1,3,5:6:2,4";

        //when
        int result = calculator.sum(str);

        //Then
        assertThat(result).isEqualTo(21);
    }
}
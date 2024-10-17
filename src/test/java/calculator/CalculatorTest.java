package calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 문자열이_null일_경우() {
        //given
        final Calculator calculator = new Calculator();
        final String str = null;

        //when
        int result = calculator.sum(str);

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 문자열이_비었을_경우() {
        //given
        final Calculator calculator = new Calculator();
        final String str = "";

        //when
        int result = calculator.sum(str);

        //Then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 예외_다른_문자가_있을_경우() {
        //given
        final Calculator calculator = new Calculator();
        final String str = "1,3,5:6-2,4";

        //when, Then
        assertThatThrownBy(() -> calculator.sum(str))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_문자열_찾기() {
        //given
        final Calculator calculator = new Calculator();
        final String str = "//;\\n1;2;3";

        //when
        String result = calculator.findCustomSeparator(str);

        //Then
        assertThat(result).isEqualTo(";");
    }

    @Test
    void 커스텀_문자가_있는_문자열_합치기() {
        //given
        final Calculator calculator = new Calculator();
        final String str = "//;\\n1;2;3";

        //when
        int result = calculator.sum(str);

        //Then
        assertThat(result).isEqualTo(6);
    }
}
package calculator.Delimiter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Delimiter.BasicDelimiter;
import Delimiter.CustomDelimiter;
import org.junit.jupiter.api.Test;

public class CustomDelimiterTest {

    @Test
    void 커스텀_구분자_처리() {
        //given
        String example = "//;\\n1;2;3";
        int[] result = {1, 2, 3};
        //when
        int[] numbers = CustomDelimiter.getNumber(example);
        //then
        assertThat(numbers).isEqualTo(result);
    }

    @Test
    void 커스텀_구분자_처리_예외_음수() {
        //given
        String example = "//;\\n1;2,-3;4";
        //when, then
        assertThatThrownBy(() -> CustomDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_처리_예외_연속된_구분자() {
        //given
        String example = "//;\\n1;;2,-3;4";
        //when, then
        assertThatThrownBy(() -> CustomDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_처리_예외_커스텀_구분자_지정_마무리() {
        //given
        String example = "//;n:1,2;3";
        //when, then
        assertThatThrownBy(() -> CustomDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_구분자_처리_예외_구분자_이외의_문자() {
        //given
        String example = "//;\\n:1,2;3^2";
        //when, then
        assertThatThrownBy(() -> BasicDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

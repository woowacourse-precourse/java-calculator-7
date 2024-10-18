package calculator.Delimiter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import Delimiter.BasicDelimiter;
import org.junit.jupiter.api.Test;

public class BasicDelimiterTest {

    @Test
    void 기본_구분자_처리() {
        //given
        String example = "1,2,3:4";
        int[] result = {1, 2, 3, 4};
        //when
        int[] numbers = BasicDelimiter.getNumber(example);
        //then
        assertThat(numbers).isEqualTo(result);
    }

    @Test
    void 기본_구분자_처리_예외_음수() {
        //given
        String example = "1,2,-3:4";
        //when, then
        assertThatThrownBy(() -> BasicDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_구분자_처리_예외_연속된_구분자() {
        //given
        String example = "1,2,,3:4";
        //when, then
        assertThatThrownBy(() -> BasicDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 기본_구분자_이외의_문자() {
        //given
        String example = "1,2,3:4<3";
        //when, then
        assertThatThrownBy(() -> BasicDelimiter.getNumber(example))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

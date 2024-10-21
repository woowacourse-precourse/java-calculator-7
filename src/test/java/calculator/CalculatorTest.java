package calculator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 주어진_숫자리스트를_더한다() {
        //given
        Calculator sut = new Calculator();

        //when
        int result = sut.add(List.of(1, 2, 3));

        //then
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void 빈_숫자리스트가_전달되면_0을_반환한다() {
        //given
        Calculator sut = new Calculator();

        //when
        int result = sut.add(List.of());

        //then
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void 덧셈결과가_최대값을_넘어서면_예외가_발생한다() {
        //given
        Calculator sut = new Calculator();

        //expected
        Assertions.assertThatThrownBy(() ->
                        sut.add(List.of(Integer.MAX_VALUE, 1)))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("덧셈 결과가 최대값을 넘습니다.");
    }
}
package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    void 음수를_입력한_경우() {
        //given
        String[] strings = {"-1"};
        Number number = new Number();

        //when & then
        assertThatThrownBy(() -> {
            for (String string : strings) {
                number.validateNumber(string);
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력할 수 있습니다.");
    }

    @Test
    void 숫자와_구분자_사이에_공백을_입력한_경우() {
        //given
        String[] strings = {"-1 "};
        Number number = new Number();

        //when & then
        assertThatThrownBy(() -> {
            for (String string : strings) {
                number.validateNumber(string);
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 계산할 수 있습니다.");
    }

    @Test
    void 구분자에_해당하지_않는_문자를_입력한_경우() {
        //given
        String[] strings = {"a", "1", "2"};
        Number number = new Number();

        //when & then
        assertThatThrownBy(() -> {
            for (String string : strings) {
                number.validateNumber(string);
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 계산할 수 있습니다.");
    }

    @Test
    void 리스트에_저장된_숫자_덧셈() {
        //given
        Number number = new Number();
        number.addNumber(2);
        number.addNumber(0);
        number.addNumber(5);

        //when
        int result = number.plusNumber();

        //then
        assertThat(result).isEqualTo(7);
    }
}

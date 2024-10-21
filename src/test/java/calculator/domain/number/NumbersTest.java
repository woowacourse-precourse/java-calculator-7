package calculator.domain.number;

import static calculator.global.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 추출한_숫자가_숫자_형식이_아닐_경우_예외_처리() {
        //given
        String extraction = "A";
        Numbers numbers = new Numbers();

        //when

        //then
        Assertions.assertThatThrownBy(() -> numbers.addNumber(extraction))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NUMBER_FORMAT_ERROR_MESSAGE);
    }

    @Test
    void 추출한_숫자를_숫자열에_등록() {
        //given
        String extraction = "16";
        Numbers numbers = new Numbers();

        //when
        numbers.addNumber(extraction);

        //then
        assertThat(numbers.toInteger()).contains(Integer.parseInt(extraction));
    }
}
package calculator.domain;


import static calculator.global.constant.ErrorMessage.CUSTOM_SEPARATOR_INDEX_ERROR_MESSAGE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LetterMannagerTest {
    @Test
    void 커스텀_구분자_입력_시_끝나는_문자열이_나오지_않을_경우_예외_처리() {
        //given
        String letters = "//hello";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);

        //then
        Assertions.assertThatThrownBy(letterMannager::splitCustomSeparator)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CUSTOM_SEPARATOR_INDEX_ERROR_MESSAGE);
    }

    @Test
    void 커스텀_구분자를_추출() {
        //given
        String separator = ";";
        String letters = "//" + separator + "\n";
        LetterMannager letterMannager;

        //when
        letterMannager = new LetterMannager(letters);
        letterMannager.splitCustomSeparator();

        //then
        Assertions.assertThat(letterMannager.getSeparators().contains(separator)).isEqualTo(true);
    }

}
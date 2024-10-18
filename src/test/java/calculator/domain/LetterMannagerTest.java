package calculator.domain;


import calculator.global.constant.ErrorMessage;
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
                .hasMessage(ErrorMessage.CUSTOM_SEPARATOR_INDEX_ERROR_MESSAGE);
    }

}
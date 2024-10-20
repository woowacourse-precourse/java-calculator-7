package calculator.domain;


import calculator.global.constant.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LetterManagerTest {
    @Test
    void 커스텀_구분자를_추출() {
        //given
        String separator = ";";
        String letters = "//" + separator + "\\n";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getSeparators().contains(separator)).isEqualTo(true);
    }

    @Test
    void 커스텀_구분자가_없는_상황에서_입력받은_문자열에서_숫자를_추출() {
        //given
        String letters = "1,2:3";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(1)).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(2)).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(3)).isEqualTo(true);
    }

    @Test
    void 커스텀_구분자가_있는_상황에서_입력받은_문자열에서_숫자를_추출() {
        //given
        String letters = "//;\\n1;2";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(1)).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(2)).isEqualTo(true);
    }

    @Test
    void 추출한_문자가_구분자에_등록되어_있지_않다면_예외_처리() {
        //given
        String letters = "1;2";

        //when

        //then
        Assertions.assertThatThrownBy(() -> new LetterManager(letters))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
    }

    @Test
    void 커스텀_구분자가_문자열_중간에_나오는_경우_커스텀_구분자_추출() {
        //given
        String letters = "3//;\\n1;2";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getSeparators().contains(";")).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().size()).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자가_두_번_나올_때_커스텀_구분자_추출() {
        //given
        String letters = "//;\\n1//@\\n2@3";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getSeparators().contains(";")).isEqualTo(true);
        Assertions.assertThat(letterManager.getSeparators().contains("@")).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().size()).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_길이가_2일_경우() {
        //given
        String letters = "//;;\\n1;;2:3";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getSeparators().contains(";;")).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(1)).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(2)).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(3)).isEqualTo(true);
    }

    @Test
    void 두자리_숫자_추출() {
        //given
        String letters = "11,22";
        LetterManager letterManager;

        //when
        letterManager = new LetterManager(letters);

        //then
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(11)).isEqualTo(true);
        Assertions.assertThat(letterManager.getNumbers().toInteger().contains(22)).isEqualTo(true);
    }
}
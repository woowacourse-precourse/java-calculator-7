package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LetterManagerTest {
    @Test
    void 커스텀_구분자를_구분자로_치환() {
        //given
        String[] separator = {";", "@"};
        String letters = "//;\\n1//@\\n2@3";
        LetterManager letterManager = new LetterManager();

        //when
        String newLetters = letterManager.replaceCustomSeparatorToSeparator(letters, separator);

        //then
        Assertions.assertThat(newLetters).isEqualTo(";1@2@3");
    }
}
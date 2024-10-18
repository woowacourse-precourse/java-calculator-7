package calculator.domain.letter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SeparatorTest {

    @Test
    void 구분자_등록() {
        //given
        String separatorLetter = ";";
        Separator separator = new Separator(separatorLetter);

        //when

        //then
        Assertions.assertThat(separator.toString()).isEqualTo(separatorLetter);
    }

}
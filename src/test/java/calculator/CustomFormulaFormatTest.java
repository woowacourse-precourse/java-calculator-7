package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class CustomFormulaFormatTest {

    @Test
    void 커스텀_구분자의_처음_형식과_일치하면_TRUE를_반환한다() {
        //given & when
        boolean actual = CustomFormulaFormat.hasFirstFormat("//;");

        //then
        assertThat(actual).isTrue();
    }

    @Test
    void 커스텀_구분자의_처음_형식과_불일치하면_FALSE를_반환한다() {
        //given & when
        boolean actual = CustomFormulaFormat.hasFirstFormat("/&");

        //then
        assertThat(actual).isFalse();
    }

    @Test
    void 커스텀_구분자의_마지막_형식과_일치하면_TRUE를_반환한다() {
        //given & when
        boolean actual = CustomFormulaFormat.hasLastFormat("//;\\n", 3);

        //then
        assertThat(actual).isTrue();
    }

    @Test
    void 커스텀_구분자의_마지막_형식과_불일치하면_FALSE를_반환한다() {
        //given & when
        boolean actual = CustomFormulaFormat.hasLastFormat("//;\\\\n", 3);

        //then
        assertThat(actual).isFalse();
    }

}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DelimiterAndNumberTest {

    @Test
    void 기본_구분자_문자열_분리() {
        assertSimpleTest(() -> {
            DelimiterAndNumber result = DelimiterAndNumber.parse("1,2:3");
            assertThat(result.getDelimiter()).isEqualTo("[,:]");
            assertThat(result.getNumbers()).isEqualTo("1,2:3");
        });
    }

    @Test
    void 커스텀_구분자_문자열_분리() {
        assertSimpleTest(() -> {
            DelimiterAndNumber result = DelimiterAndNumber.parse("//;\\n1");
            assertThat(result.getDelimiter()).isEqualTo(";");
            assertThat(result.getNumbers()).isEqualTo("1");
        });
    }

    @Test
    void 커스텀_구분자_문자열_분리_접두사_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> DelimiterAndNumber.parse(";\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_문자열_분리_접미사_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> DelimiterAndNumber.parse("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_문자열_분리_순서_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> DelimiterAndNumber.parse("\\n;//1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

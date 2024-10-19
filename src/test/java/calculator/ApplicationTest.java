package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void isInvalidFormatTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input = "//;\n1;2;3";
        // when
        // then
    }

    @Test
    void isCustomPatternTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input = "//;\\n1;2;3";
        // when
        final boolean isCustomPattern = inputValidator.isCustomPattern(input);
        // then
        assertThat(isCustomPattern).isTrue();
    }

//    @Test
//    void isMetaCharactersTest() {
//        // given
//        final InputValidator inputValidator = new InputValidator();
//        final String customPattern = "a";
//        // when
//        final boolean isMetaCharacters = inputValidator.isMetaCharacters(customPattern);
//        // then
//        assertThat(isMetaCharacters).isFalse(); // false
//    }

    @Test
    void toStringArrTest() {
        // given
        final Converter converter = new Converter();
        final String input = "//.\\n1.2.3.4.5";
        // when
        String[] stringArr = converter.toStringArr(input); // {1,2,3,4,5}
        // then
        assertThat(stringArr).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    void formatTest() {
        // given
        final NumberFormatter formatter = new NumberFormatter();
        final double sum = 5;
        // when
        final String formatted = formatter.format(sum);
        // then
        assertThat(formatted).matches("5");
    }
}

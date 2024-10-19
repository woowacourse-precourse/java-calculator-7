package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiDelimiterTest {

    private final MultiDelimiter multiDelimiter = new MultiDelimiter();

    @Test
    @DisplayName("쉼표 구분자로 문자열 분리")
    void shouldSplitByComma() {
        // given
        String input = "1,2,3";

        assertSplitResult(input, new String[] {"1", "2", "3"});
    }

    @Test
    @DisplayName("콜론 구분자로 문자열 분리")
    void shouldSplitByColon() {
        // given
        String input = "1:2:3";

        assertSplitResult(input, new String[] {"1", "2", "3"});

    }

    @Test
    @DisplayName("쉼표와 콤마로 문자열 분리")
    void shouldSplitByCommaAndColon() {
        // given
        String input = "1,2:3:4";

        assertSplitResult(input, new String[] {"1", "2", "3", "4"});
    }

    @Test
    @DisplayName("커스텀 구분자로 문자열 분리")
    void shouldSplitByCustomDelimiter() {
        // given
        String input = "//;\n1;2;3";

        assertSplitResult(input, new String[] {"1", "2", "3"});
    }

    @Test
    @DisplayName("구분자 없는 경우 문자열 분리하지 않는 테스트")
    void shouldSplitNothing() {
        // given
        String input = "123";

        assertSplitResult(input, new String[] {"123"});
    }

    @Test
    @DisplayName("커스텀 구분자 존재하지만 문자열에 존재하지 않는 경우 테스트")
    void shouldSplitNothing2() {
        // given
        String input = "//*\n123";

        assertSplitResult(input, new String[] {"123"});
    }

    private void assertSplitResult(String input, String[] actual) {

        // when
        String[] strings = multiDelimiter.splitWithDelimiter(input);

        // then
        assertThat(strings).isEqualTo(actual);
    }

}

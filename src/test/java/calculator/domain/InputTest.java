package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    @DisplayName("커스텀 구분자가 있는 경우 Input 생성 테스트")
    void testCreateInputWithCustomDelimiterPart() {
        // given
        String input = "//;\\n1,2:3;4";
        String expectedDelimiterPart = "//;\\n";
        String expectedNumberPart = "1,2:3;4";

        // when
        Input actual = new Input(input);

        // then
        assertAll(
                () -> assertThat(actual.getDelimiterPart()).isEqualTo(expectedDelimiterPart),
                () -> assertThat(actual.getNumberPart()).isEqualTo(expectedNumberPart)
        );
    }

    @Test
    @DisplayName("커스텀 구분자가 없는 경우 Input 생성 테스트")
    void testCreateInputWithoutCustomDelimiterPart() {
        // given
        String input = "1,2:3,4";
        String expectedDelimiterPart = "";
        String expectedNumberPart = "1,2:3,4";

        // when
        Input actual = new Input(input);

        // then
        assertAll(
                () -> assertThat(actual.getDelimiterPart()).isEqualTo(expectedDelimiterPart),
                () -> assertThat(actual.getNumberPart()).isEqualTo(expectedNumberPart)
        );
    }

    @Test
    @DisplayName("커스텀 구분자가 이상하게 들어오는 경우 Input 생성 테스트")
    void testCreateInputWithWrongDelimiterPart() {
        // given
        String input = "//;1,2:3;4";
        String expectedDelimiterPart = "";
        String expectedNumberPart = "//;1,2:3;4";

        // when
        Input actual = new Input(input);

        // then
        assertAll(
                () -> assertThat(actual.getDelimiterPart()).isEqualTo(expectedDelimiterPart),
                () -> assertThat(actual.getNumberPart()).isEqualTo(expectedNumberPart)
        );

    }
}

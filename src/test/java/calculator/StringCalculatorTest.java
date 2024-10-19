package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    @DisplayName("주어진 문자열에서 커스텀 구분자를 판별할 수 있다.")
    void testFindCustomDelimiter() {
        String[] specialCharacters = {";", "*", "#", "&", "^", "%", "$", "@", "!"};
        for (String delimiter : specialCharacters) {
            // given
            String input = "//" + delimiter + "\n";
            // when
            String result = StringCalculator.findCustomDelimiter(input);
            // then
            assertThat(result).isEqualTo(delimiter);
        }
    }

    @Test
    @DisplayName("주어진 문자열에 커스텀 구분자가 없는 경우 빈 문자열을 반환한다.")
    void testNoCustomDelimiter() {
        // given
        String input = "1,2:3";
        // when
        String result = StringCalculator.findCustomDelimiter(input);
        // then
        assertThat(result).isEqualTo("");
    }
}
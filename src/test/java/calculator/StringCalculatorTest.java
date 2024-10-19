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

    @Test
    @DisplayName("구분자를 기준으로 문자열을 분리한다.")
    void testSplitString() {
        // given
        String input1 = "1,2,3";
        String customDelimiter1 = "";

        String input2 = "//;\n1;2;3";
        String customDelimiter2 = ";";

        // when
        String[] result1 = StringCalculator.splitString(input1, customDelimiter1);
        String[] result2 = StringCalculator.splitString(input2, customDelimiter2);

        // then
        assertThat(result1).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(result2).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("문자열로 된 숫자들의 합을 구한다.")
    void testSumNumbers() {
        // given
        String[] input1 = new String[]{"1", "2", "3"};
        String[] input2 = new String[]{"1"};

        // when
        int result1 = StringCalculator.sumNumbers(input1);
        int result2 = StringCalculator.sumNumbers(input2);

        // then
        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(1);
    }
}
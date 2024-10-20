package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class DefaultInputTest {
    private DefaultInput defaultInput;

    @DisplayName("[기본 구분자] 정상 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "", "1,3333333333"})
    void 정상_입력(String userInput) {
        // given
        long expectedSum = calculateExpectedSum(userInput);
        defaultInput = new DefaultInput(userInput);
        
        // when
        long actualSum = defaultInput.sumCalculate();

        // then
        assertThat(actualSum).isEqualTo(expectedSum);
    }

    @DisplayName("[기본 구분자] 음수값 입력시 예외발생")
    @Test
    void 음수값_입력시_예외발생() {
        // given
        String userInput = "1,-2,3";

        // when, then
        assertThatException().isThrownBy(() -> new DefaultInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자_외의_문자를_입력시_예외발생")
    @Test
    void 구분자_외의_문자를_입력시_예외발생() {
        // given
        String userInput = "1,m,3";

        // when, then
        assertThatException().isThrownBy(() -> new DefaultInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백_입력시_예외발생")
    @Test
    void 공백_입력시_예외발생() {
        // given
        String userInput = "1, 2, 3";

        // when, then
        assertThatException().isThrownBy(() -> new DefaultInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구분자의 개수가 숫자 개수 이상인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,", ",,", "1,,2,3"})
    void 구분자의_개수가_숫자_개수_이상인_경우(String userInput) {
        // when, then
        assertThatException().isThrownBy(() -> new DefaultInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }


    private long calculateExpectedSum(String input) {
        String[] numbers = input.split("[,:]"); // 기본 구분자는 쉼표, 콜론
        long sum = 0;
        for (String number : numbers) {
            if (!number.isEmpty()) { // 빈 문자열을 무시
                sum += Long.parseLong(number);
            }
        }
        return sum;
    }
}
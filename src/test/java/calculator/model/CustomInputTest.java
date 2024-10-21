package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomInputTest {
    private CustomInput customInput;

    @Test
    @DisplayName("[커스텀 구분자] 정상입력")
    void 정상_입력() {
        // given
        String userInput = "//asd\\n1asd2asd3";
        customInput = new CustomInput(userInput);

        // when
        long actualSum = customInput.sumCalculate();

        // then
        assertThat(actualSum).isEqualTo(6);
    }

    @Test
    @DisplayName("[커스텀 구분자] 음수인 경우 예외 출력")
    void 음수인_경우_예외발생() {
        // given
        String userInput = "//;\\1;2;-3";

        // when, then
        assertThatException().isThrownBy(() -> new CustomInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[커스텀 구분자] 숫자가아닌 음수가 주어진 경우")
    void 숫자가아닌_음수가_주어진_경우_예외발생() {
        // given
        String userInput = "//;\\n1;m;3";

        // when, then
        assertThatException().isThrownBy(() -> new CustomInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[커스텀 구분자] 구분자로 숫자가 사용된 경우")
    void 구분자가_숫자인_경우_예외발생() {
        // given
        String userInput = "//3\\n13233";

        // when, then
        assertThatException().isThrownBy(() -> new CustomInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[커스텀 구분자] 숫자가 아닌 문자가 사용된 경우")
    void 숫자가_아닌_문자가_사용된_경우_예외발생() {
        // given
        String userInput = "//;\\n1;m;3";

        // when, then
        assertThatException().isThrownBy(() -> new CustomInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[커스텀 구분자] 구분자의 개수가 숫자 이상인 경우")
    void 구분자의_개수가_숫자_이상인_경우_예외발생() {
        // given
        String userInput = "//;\\n1;2;3;;";

        // when, then
        assertThatException().isThrownBy(() -> new CustomInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("[커스텀 구분자] 계산부분이 공백인 경우")
    void 계산부분이_공백인_경우_0_출력() {
        // given
        String userInput = "//;\\n";
        customInput = new CustomInput(userInput);

        // when, then
        assertThat(0).isEqualTo(customInput.sumCalculate());
    }

    @Test
    @DisplayName("[커스텀 구분자] 커스텀 구분자 포맷이 유효하지 않은 경우")
    void 커스텀_구분자의_포맷이_유효하지_않은_경우_예외발생() {
        // given
        String userInput = "//;\\m1;2;3";

        // when, then
        assertThatException().isThrownBy(() -> new CustomInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
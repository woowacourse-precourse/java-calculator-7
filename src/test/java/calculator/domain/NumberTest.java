package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력값에_어떤값도_없는경우_예외가_발생하지_않는다(String element) {
        //when & then
        Assertions.assertThatCode(() -> {
            Number number = new Number(element);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 입력값에_어떤값도_없는경우_0으로_초기화된다(String element) {
        //when & then
        Number number = new Number(element);

        Assertions.assertThat(number.getValue()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcd"})
    void 입력값이_숫자가_아닐경우_예외가_발생한다(String element) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
                    Number number = new Number(element);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자의 형식이 올바르지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 입력값이_양수가_아닐경우_예외가_발생한다(String element) {
        //when & then
        Assertions.assertThatThrownBy(() -> {
                    Number number = new Number(element);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 양수여야 합니다.");
    }
}

package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {

    @Test
    @DisplayName("입력된 숫자들의 합을 반환한다.")
    void sum() {
        // given
        List<String> input = List.of("1", "2", "3");
        Numbers numbers = new Numbers(input);

        // when
        int sum = numbers.sum();

        // then
        assertThat(sum).isEqualTo(6);
    }
    
    @Test
    @DisplayName("숫자가 아닌 문자가 입력될 경우 예외가 발생한다.")
    void throwExceptionWhenNotIntegerInput() {
        // given
        List<String> input = List.of("1", "2", "a");

        // then
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package calculator.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class AdditionInputTest {
    @Test
    void null_값이_AdditionInput에_전달되면_예외_발생() {
        assertThatThrownBy(() -> new AdditionInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("null은 입력할 수 없습니다.");
    }

    @Test
    void AdditionInput에_전달된_입력값이_빈문자열일_경우_정상처리() {
        AdditionInput input = new AdditionInput("");
        assertThat(input.input()).isEqualTo("");
    }
}
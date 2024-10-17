package calculator.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {

    @DisplayName("사용자 입력은 null일 수 없다.")
    @Test
    void userInputIsNotNull() {
        //given
        String input = null;
        //when
        //then
        assertThatThrownBy(() -> new UserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자의 입력값이 null 일 수 없습니다.");
    }

}
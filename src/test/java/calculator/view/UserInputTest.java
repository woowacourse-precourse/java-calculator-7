package calculator.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {
    @DisplayName("입력시 사용되는 상수 확인")
    @Test
    void checkViewInputMessage(){
        assertThat(UserInput.InputMessage.INPUT_PROMPT.getMessage()).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }
    @DisplayName("입력값 확인")
    @Test
    void checkViewInputString(){
        String input = "//;\\n123,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        assertEquals(input, userInput.promptUserInput());

        System.setIn(System.in);
    }
}

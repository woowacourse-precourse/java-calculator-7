package calculator.controller;

import calculator.view.UserInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputControllerTest {
    @DisplayName("생성자 입력값 이용 초기화 확인")
    @Test
    void checkInputString(){
        String input = "//;\\n123,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();
        UserInputController userInputController = new UserInputController(userInput);

        assertEquals(input, userInputController.getUserInputMessage());

        System.setIn(System.in);
    }
    @DisplayName("커스텀 구분자 보유 시 설정 확인")
    @Test
    void checkHasCustomDelimiter(){
        String input = "//;\\n123,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();
        UserInputController userInputController = new UserInputController(userInput);

        assertEquals(';', userInputController.getDelimiter().CUSTOM_DELIMITER);

        System.setIn(System.in);
    }
    @DisplayName("커스텀 구분자 미보유 시 설정 확인")
    @Test
    void checkNotHasCustomDelimiter(){
        String input = "123,3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();
        UserInputController userInputController = new UserInputController(userInput);

        assertEquals(null, userInputController.getDelimiter().CUSTOM_DELIMITER);

        System.setIn(System.in);
    }
    @DisplayName("숫자없을 때 예외처리")
    @Test
    void checkNotHasNumber(){
        String input = ",,,:::,";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> new UserInputController(userInput))
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(System.in);
    }
    @DisplayName("구분자없을 때 예외처리")
    @Test
    void checkNotHasDelimiter(){
        String input = "123123123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        assertThatThrownBy(() -> new UserInputController(userInput))
                .isInstanceOf(IllegalArgumentException.class);

        System.setIn(System.in);
    }
}

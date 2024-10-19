package calculator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("InputHandler 단위 테스트")
public class InputHandlerTest {
    @Test
    @DisplayName("[성공] - convertInput 테스트 with 구분자")
    void success_convertInput_separator() {
        //given
        InputHandler inputHandler = new InputHandler();
        String input = "//plus\\n1,2;3plus4";

        //when
        String convertedInput = inputHandler.convertInput(input);

        //then
        Assertions.assertThat(convertedInput).isEqualTo("1,2;3,4");
    }

    @Test
    @DisplayName("[성공] - convertInput 테스트 without 구분자")
    void success_convertInput_noSeparator() {
        //given
        InputHandler inputHandler = new InputHandler();
        String input = "1,2;3,4";

        //when
        String convertedInput = inputHandler.convertInput(input);

        //then
        Assertions.assertThat(convertedInput).isEqualTo("1,2;3,4");
    }

    @Test
    @DisplayName("[예외] - convertInput 테스트(input 형식 에러)")
    void exception_convertInput_input() {
        //given
        InputHandler inputHandler = new InputHandler();
        String input = "//hello\\1,2;3,4";

        //when, then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputHandler.convertInput(input));
    }

    @Test
    @DisplayName("[성공] - getNumbers 테스트")
    void success_getNumbers() {
        //given
        InputHandler inputHandler = new InputHandler();
        String input = "123,223,323;412";

        //when
        List<Long> numbers = inputHandler.getNumbers(input);

        //then
        Assertions.assertThat(numbers).containsExactly(123L, 223L, 323L, 412L);
    }

    @Test
    @DisplayName("[예외] - getNumbers 테스트(문자, long 범위 초과, 음수)")
    void exception_getNumbers() {
        //given
        InputHandler inputHandler = new InputHandler();
        String inputNotNum = "123,abc";
        String inputOverflow = "9223372036854775807123";
        String inputMinus = "-123,-1234";

        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputHandler.getNumbers(inputNotNum));
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputHandler.getNumbers(inputOverflow));
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class,
                () -> inputHandler.getNumbers(inputMinus));
    }
}

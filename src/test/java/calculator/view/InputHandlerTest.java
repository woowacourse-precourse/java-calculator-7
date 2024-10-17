package calculator.view;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputHandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"//;\\n1;2;3, 5", "1:2:3, 0"})
    void 커스텀_구분자가_있는지_확인(String input, int expected) {
        //given
        InputHandler inputHandler = new InputHandler();

        //when
        int length = inputHandler.isCustomDelimiter(input);

        //then
        Assertions.assertThat(length).isEqualTo(expected);
    }

}
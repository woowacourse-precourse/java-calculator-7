package calculator.io;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConsoleHandlerTest {

    public static final InputConsoleHandler INPUT_CONSOLE_HANDLER = new InputConsoleHandler();

    @Test
    @DisplayName("기본 구분자를 사용하여 입력한 데이터를 정상적으로 분리하여 반환한다")
    void inputSplit() {
        // given
        String input = "1:2:3";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();

        assertThat(inputSplit).containsExactly("1", "2", "3");

        System.setIn(System.in);
        Console.close();
    }
}
package calculator.io;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    @DisplayName("긴 길이의 입력도 정상적으로 반환한다.")
    void inputSplitLong() {
        // given
        StringBuilder inputBuilder = new StringBuilder();
        List<String> expected = new ArrayList<>();

        int numData = 100;
        for (int i = 1; i <= numData; i++) {
            inputBuilder.append(i);
            if (i < numData) {
                inputBuilder.append(":");
            }
            expected.add(String.valueOf(i));
        }
        String input = inputBuilder.toString();

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();

        assertThat(inputSplit).containsExactlyElementsOf(
                expected
        );

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("구분자가 여러개여도 정상적으로 분리하여 반환한다")
    void inputSplitWithMultipleSeparators() {
        // given
        String input = "1,2:3";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();
        assertThat(inputSplit).containsExactly("1", "2", "3");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("커스텀 구분자를 포함한 입력도 정상적으로 반환한다")
    void inputSplitWithCustomSeparator() {
        // given
        String input = "//;\\n1;2;3";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();
        assertThat(inputSplit).containsExactly("1", "2", "3");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("이모지도 구분자로 사용할 수 있다")
    void inputSplitWithEmoji() {
        // given
        String input = "//\uD83C\uDF51\\n1\uD83C\uDF512\uD83C\uDF513";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();
        assertThat(inputSplit).containsExactly("1", "2", "3");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("사용자의 커스텀 구분자가 정규표현식의 메타문자인 경우도 잘 분리하여 반환한다")
    void findCustomSeparatorWithRegexSymbol() {
        // given
        String input = "//*\\n1*2*3";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();
        assertThat(inputSplit).containsExactly("1", "2", "3");

        System.setIn(System.in);
        Console.close();
    }


}
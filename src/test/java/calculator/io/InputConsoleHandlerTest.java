package calculator.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("아무 값도 전달하지 않으면 빈 문자열을 반환한다")
    void blankInput() {
        // given
        String input = System.lineSeparator();

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();
        assertThat(inputSplit.length).isEqualTo(0);

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("하나의 숫자만 입력하면 그 숫자 그대로 반환한다")
    void singleInput() {
        // given
        String input = "124";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        String[] inputSplit = INPUT_CONSOLE_HANDLER.getUserInput();
        assertThat(inputSplit).containsExactly("124");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("커스텀 구분자를 소숫점으로 쓰면 애플리케이션을 종료한다")
    void inputWithFloatingPoint() {
        // given
        String input = "//.\\n1.2.3";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        assertThatThrownBy(INPUT_CONSOLE_HANDLER::getUserInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구분자로 소숫점 (.) 을 사용할 수 없습니다. 애플리케이션을 종료합니다");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("계산할 숫자 데이터를 전달하지 않으면 애플리케이션을 종료한다")
    void throwExceptionBadOperandsData() {
        // given
        String input = "asdf";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        assertThatThrownBy(INPUT_CONSOLE_HANDLER::getUserInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용되지 않은 입력입니다. 애플리케이션을 종료합니다.");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("커스텀 구분자 지정을 하지 않고 커스텀 구분자를 사용하면 애플리케이션을 종료한다")
    void throwExceptionBadCustomSeparator() {
        // given
        String input = "1a2a3";

        // when
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // then
        assertThatThrownBy(INPUT_CONSOLE_HANDLER::getUserInput)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자의 지정 방법이 잘못되었습니다. 애플리케이션을 종료합니다.");

        System.setIn(System.in);
        Console.close();
    }

    @Test
    @DisplayName("재실행 메시지에 허용되지 않은 숫자를 입력하면 애플리케이션을 종료한다.")
    void test() {

        String input = "6";

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(INPUT_CONSOLE_HANDLER::isAppEnd)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용되지 않은 동작입니다. 애플리케이션을 종료합니다.");
    }

}
package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.converter.EscapeNewLineConverter;
import calculator.delimiter.DelimiterChecker;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    @DisplayName(",는 기본 구분자이다.")
    void useGeneralDelimiter() {
        // given
        String userInput = "1,2,3";
        userInput = getUserInput(userInput); // 콘솔 환경 적용

        DelimiterChecker delimiterChecker = new DelimiterChecker();

        // when
        boolean isCustomDelimiter = delimiterChecker.isCustomDelimiter(userInput);

        // then
        assertThat(isCustomDelimiter).isFalse();
    }

    @Test
    @DisplayName(",와 : 모두 기본 구분자이다.")
    void useGeneralDelimiter2() {
        // given
        String userInput = "1,2:3";
        userInput = getUserInput(userInput); // 콘솔 환경 적용

        DelimiterChecker delimiterChecker = new DelimiterChecker();

        // when
        boolean isCustomDelimiter = delimiterChecker.isCustomDelimiter(userInput);

        // then
        assertThat(isCustomDelimiter).isFalse();
    }

    @Test
    @DisplayName("//와 \n 사이에 커스텀 구분자를 지정할 수 있다.")
    void useCustomDelimiter() {
        // given
        String userInput = "//t\\n1t2t3";
        userInput = getUserInput(userInput); // 콘솔 환경 적용

        DelimiterChecker delimiterChecker = new DelimiterChecker();

        // when
        boolean isCustomDelimiter = delimiterChecker.isCustomDelimiter(userInput);

        // then
        assertThat(isCustomDelimiter).isTrue();
    }

    private String getUserInput(String input) {
        Scanner sc = new Scanner(input);
        input = sc.nextLine();

        EscapeNewLineConverter escapeNewLineConverter = new EscapeNewLineConverter();
        return escapeNewLineConverter.convert(input);
    }

}
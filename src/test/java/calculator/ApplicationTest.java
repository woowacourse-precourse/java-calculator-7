package calculator;

import calculator.enums.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 피연산자로_음수를_허용하지_않음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {":::", ",,,", "//-\\n---"})
    void 입력에_구분자만_존재할_떄_결과값_0_출력(String input) {
        assertSimpleTest(() -> {
                    run(input);
                    assertThat(output()).contains("결과 : 0");
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;;\\n1;;2;;3", "//\\n123"})
    void 커스텀_구분자_문법에서_커스텀_구분자의_길이가_1이_아닐_때_예외_발생(String input) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_CUSTOM_SEPARATOR_LENGTH.getMessage())
        );
    }

    @Test
    void 커스텀_구분자가_공백일_떄_결과값_출력() {
        String input = "// \\n1 2 3";
        String expect = "결과 : 6";

        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expect);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"01:2:003", "//;\\n1;002;03"})
    void 숫자가_0으로_시작할_때_결과값_출력(String input) {
        String expect = "결과 : 6";

        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expect);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//+\\n1+2+3", "//(\\n1(2(3"})
    void 정규표현식_메타문자를_커스텀_구분자로_사용했을_경우_결과값_출력(String input) {
        String expect = "결과 : 6";

        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expect);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", " ","//-\\n"})
    void 빈_문자열도_결과값_출력(String input) {
        String expect = "결과 : 0";

        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains(expect);
        });
    }

    @Test
    void 커스텀_구분자로_숫자가_들어왔을_때_오류_발생() {
        String input = "//2\\n12324";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.CUSTOM_SEPARATOR_IS_NUMBER.getMessage())
        );
    }

    @Test
    @DisplayName("입력에_\\n이_두번_존재할_때_오류_발생")
    void invalidSyntaxTest() {
        String input = "//;\\n\\n1;2;3";

        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CUSTOM_SEPARATOR_SYNTAX.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:a:3", "1:^:3", "//-\\n1-a-b", "//-\\n1-^-3"})
    void 피연산자에_다른_문자가_입력됐을_때_오류_발생(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_OPERAND.getMessage())
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

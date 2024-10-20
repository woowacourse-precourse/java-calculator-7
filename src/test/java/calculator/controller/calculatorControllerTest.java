package calculator.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class calculatorControllerTest extends NsTest {

    @ParameterizedTest
    @ValueSource(strings = {"///\\n1/2/3", "//\\\\n1\\2\\3", "//n\\n1n2n3", "// \\n1 2 3", "1,2:3", "//^\\n1^2^3"})
    void 문자열_덧셈_성공_테스트(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"//]\\n1[2[3", "//1\\n1,2,3", "HelloWorld", "/\\n1", "//]]\\n1", "1,2,3,", ",1,2,3",
            "1,2,a", "-1,2,3", "1,,2"})
    void 문자열_덧셈_실패_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

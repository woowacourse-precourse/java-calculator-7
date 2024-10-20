package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.splitter.DefaultStringSplitter;
import calculator.validator.DefaultValidator;
import camp.nextstep.edu.missionutils.test.NsTest;
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

    @Test
    void 음수_포함시_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수와_0_포함시_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1,-2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정수와_소수_처리_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1.5;2.5;3");
            assertThat(output()).contains("결과 : 7.0");
        });
    }

    @Test
    void 잘못된_입력값_포함시_예외발생() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;a;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈_문자열_입력_테스트() {
        StringCalculator calculator = StringCalculator.create(
                DefaultStringSplitter.create(),
                DefaultValidator.create("")
        );
        String result = calculator.add("");
        assertThat(result).isEqualTo("0");
    }

    @Test
    void 공백_문자열_입력_테스트() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

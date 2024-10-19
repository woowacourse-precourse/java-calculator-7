package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("입력 값이 공백일 경우 예외가 발생한다.")
    void inputBlankString() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(" "))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("기본 구분자를 사용했을 때 기대한 결과값이 나온다.")
    void usingBasicDelimiter() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("여러 기본 구분자를 사용했을 때 기대한 결과값이 나온다.")
    void usingMultipleBasicDelimiter() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자를 사용했을 때 기대한 결과값이 나온다.")
    void usingCustomDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자를 혼합 사용할 때 기대한 결과값이 나온다.")
    void usingCustomAndBasicDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("입력값에 음수가 존재할 때 예외가 발생한다.")
    void inputNegativeNumberException1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값에 음수가 존재할 때 예외가 발생한다.")
    void inputNegativeNumberException2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;-2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends NsTest {
    @Test
    @DisplayName("기본 구분자 정상 입력 테스트")
    void validInputTest() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 정상 입력 테스트")
    void validCustomDelimiterTest() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자에 여러 문자 입력 테스트")
    void duplicateCustomDelimiterTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;;2;;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자 입력 테스트")
    void numberCustomDelimiterTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n21213"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 입력 테스트")
    void invalidCustomDelimiterTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자 입력 누락 테스트")
    void missOutNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1:,3,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수 입력 테스트")
    void negativeNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("허용되지 않은 문자 입력 테스트")
    void illegalCharacterTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("q:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("빈 입력 테스트")
    void emptyInputException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(""))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력이 없습니다.")
        );
    }

    @Test
    @DisplayName("숫자 하나 입력")
    void singleNumber() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    @DisplayName("쉼표로 구분된 두 숫자")
    void comma() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("콜론으로 구분된 두 숫자")
    void colon() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("쉼표와 콜론을 혼합한 여러 숫자")
    void Mix() {
        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 사용 - 세미콜론")
    void customSeparator() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    @DisplayName("커스텀 구분자와 기본 구분자 혼합")
    void customAndDefaultSeparator() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    @DisplayName("음수 입력 시 예외 발생")
    void negativeNumberException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수는 입력할 수 없습니다: -1")
        );
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력 시 예외 발생")
    void nonNumberInputException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다: a")
        );
    }

    @Test
    @DisplayName("커스텀 구분자 지정 후 숫자 없이 입력")
    void customSeparatorNoNumbersException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 숫자가 존재하지 않습니다.")
        );
    }

    @Test
    @DisplayName("커스텀 구분자 지정 후 \\n가 없을 때")
    void customSeparatorException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자 등록이 올바르지 않습니다.")
        );
    }

    @Test
    @DisplayName("빈 문자열 포함 입력 시 예외 발생")
    void emptyStringInInputException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력된 숫자가 존재하지 않습니다.")
        );
    }

    @Test
    @DisplayName("커스텀 구분자에 여러 문자 포함")
    void customMultipleSeparator() {
        assertSimpleTest(() -> {
            run("//***\\n1***2***3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

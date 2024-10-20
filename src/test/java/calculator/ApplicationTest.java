package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @DisplayName("커스텀 구분자 사용")
    @Test
    void test1() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @DisplayName("정상")
    @Test
    void exception3() {
        assertSimpleTest(() -> {
            run("//+\\n1+2+13:9");
            assertThat(output()).contains("결과 : 25");
        });
    }

    @DisplayName("문자열이 숫자 또는 '//' 외에 문자로 시작하면 안된다")
    @Test
    void exception1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("k,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("문자열이 '//' 또는 숫자로 시작해야 됩니다.")
        );
    }

    @DisplayName("'//'와 '\\n' 사이에 하나의 구분자만 있어야 한다")
    @Test
    void exception2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;+=\\\\n1+2+13;9"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("'//'와 '\\n' 사이에 하나의 구분자만 있어야 합니다.")
        );
    }

    @DisplayName("'//'와 '\\n' 사이에 유효한 구분자가 있어야 한다")
    @Test
    void exception4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1+2+13;9"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("'//'와 '\\n' 사이에 유효한 구분자가 있어야 합니다.")
        );
    }

    @DisplayName("'\\n'로 커스텀 구분자를 지정해야 한다")
    @Test
    void exception5() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;\\b1+2+13;9"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("'\\n'로 커스텀 구분자를 지정해야 합니다.")
        );
    }

    @DisplayName("커스텀 구분자로 ':'는 지정할 수 없다")
    @Test
    void exception6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자로 쉼표(,) 또는 콜론(:)은 사용할 수 없습니다.")
        );
    }

    @DisplayName("커스텀 구분자로 ','는 지정할 수 없다")
    @Test
    void exception7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("구분자로 쉼표(,) 또는 콜론(:)은 사용할 수 없습니다.")
        );
    }

    @DisplayName("커스텀 구분자로 숫자는 지정할 수 없다")
    @Test
    void exception8() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//0\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("커스텀 구분자를 올바르게 지정하지 않았습니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

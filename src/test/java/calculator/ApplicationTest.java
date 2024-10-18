package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("커스텀 구분자 한개, 숫자 한개일 때")
    void useCustomSplit() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("음수가 포함됐을 때")
    void exceptionTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test()
    @DisplayName("커스텀 구분자가 2글자 이상일 때")
    void splitLengthTest() {
        assertSimpleTest(() -> {
            run("//;;;\\n1;;;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test()
    @DisplayName("커스텀 구분자를 추가했을 때 기본 구분자와 함께 사용 테스트")
    void basicSepWithCustomSepTest() {
        assertSimpleTest(() -> {
            run("//;;;\\n1;;;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test()
    @DisplayName("커스텀 구분자가 두개 이상일 때 테스트")
    void manyCustomSepTest() {
        assertSimpleTest(() -> {
            run("//;;0;0\\\\0-\\n1;2,3:4;;5\\6");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    @DisplayName("입력값 마지막에 구분자가 있을 때")
    void lastCharIsSeperatorTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값 처음에 구분자가 있을 때")
    void firstCharIsSeperatorTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력값 처음과 마지막에 구분자가 있을 때")
    void firstAndLastCharIsSeperatorTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//abc\nabc1,2,3abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("int 범위를 넘어가는 수를 입력받았을 때")
    void beyondIntegerTest() {
        assertSimpleTest(() -> {
            run("//;\\n2147483648;2147483648");
            assertThat(output()).contains("결과 : 4,294,967,296");
        });
    }

    @Test
    @DisplayName("long 범위를 넘어가는 수를 입력받았을 때")
    void beyondLongTest() {
        assertSimpleTest(() -> {
            run("//;\\n9223372036854775808;3");
            assertThat(output()).contains("결과 : 9,223,372,036,854,775,811");
        });
    }

    @Test
    @DisplayName("long 범위를 넘어가는 수를 입력받았을 때")
    void addCommaTest() {
        assertSimpleTest(() -> {
            run("//;\\n9223372036854775808;3");
            assertThat(output()).contains("결과 : 9,223,372,036,854,775,811");
        });
    }

    @Test
    @DisplayName("구분자에 숫자가 있을 때")
    void seperatorIsNumberTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\\n9223372036854775808;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("구분자가 없을 때")
    void noSeperatorTest() {
        assertSimpleTest(() -> {
            run("//\\n9223372036854775808:3");
            assertThat(output()).contains("결과 : 9,223,372,036,854,775,811");
        });
    }

    @Test
    @DisplayName("구분자가 0일 때")
    void seperatorIsZeroTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//0\\n9223372036854775808;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("구분자의 처음이 0일 때")
    void seperatorStartIsZeroTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//0wer\\n9223372036854775808wer3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    @DisplayName("구분자의 마지막이 0일 때")
    void seperatorEndIsZeroTest() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//wer0\\n9223372036854775808wer3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

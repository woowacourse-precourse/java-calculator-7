package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationExceptionTest extends NsTest {

    @Test
    @DisplayName("예외 테스트 : 중첩 커스텀 구문자")
    void exceptionTest1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////5\\n\\n1,2,3,4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 커스텀 구문자 안에 기본 구문자")
    void exceptionTest2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 커스텀 구문자 사이에 값 미존재")
    void exceptionTest3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 입력에 양수가 아닌 0추가")
    void exceptionTest4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0100:0200"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 커스텀 구문자에 문자열 테스트")
    void exceptionTest5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//aa\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 음수값 테스트")
    void exceptionTest6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,-2,-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 특수문자 \\t")
    void exceptionTest7() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\t"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 특수문자 \\b")
    void exceptionTest9() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\b"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 특수문자 \\0")
    void exceptionTest10() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 커스텀 구분자가 문자열")
    void exceptionTest11() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//123\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트 : 숫자구문자와 0")
    void exceptionTest12() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11111111111//1\\n111111111111110"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

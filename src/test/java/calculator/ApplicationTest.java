package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
    void 예외_테스트_음수_오류() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_음수_오류2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n-1;-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_문자열_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_시작_심볼_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_시작_심볼_오류2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_시작_심볼_오류3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("[[;\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_끝_심볼_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_끝_심볼_오류2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_끝_심볼_오류3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_문자열_끝_심볼_오류4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\\n1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_피연산자_구분자_오류() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_피연산자_구분자_오류2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_피연산자_구분자() {
        assertSimpleTest(() -> {
            run("//;\\n123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    @Test
    void 예외_테스트_피연산자_구분자_오류3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;3;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_성공() {
        assertSimpleTest(() -> {
            run(("//;\\n1;2,3:4"));
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

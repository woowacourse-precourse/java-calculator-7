package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 기본_구분자_사용1() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용2() {
        assertSimpleTest(() -> {
            run("1:2");
            assertThat(output()).contains("결과 : 3");
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
    void 커스텀_구분자_식별자_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_식별자_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_식별자_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(";\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_미입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_중복_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_숫자입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//3\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_공백입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//   \\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#$%\\n1:-2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 소수_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#$%\\n1:0.2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 유효_구분자_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#$%\\n1#2.3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_연속_입력_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#$%\\n1##2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_양끝단_존재_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//#$%\\n#1#2,3#"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Override

    public void runMain() {
        Application.main(new String[]{});
    }
}

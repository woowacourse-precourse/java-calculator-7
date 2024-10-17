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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 십의_자리_수_인식() {
        assertSimpleTest(() -> {
            run("10,2;3");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 예외_테스트_공통1() { // 숫자로 혹은 '/'로 시작하지 않는 문자열
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_기본1() { // ',', ':' 외의 구분자
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1[2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀1() { // 커스텀 설정 시 오류1
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/^1^2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀2() { // 커스텀 설정 시 오류2
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^1^2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀3() { // 커스텀 설정 시 오류3
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^\\1^2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀4() { // 기본/커스텀 외의 구분자
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//^\\n1^2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

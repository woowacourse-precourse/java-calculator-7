package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_규칙_미준수1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_규칙_미준수2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/$;\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_한번에_여러개설정() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/&;\\n1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 미설정_커스텀_구분자_포함() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1,2&4,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775808"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산결과_범위_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("4611686018427387904,4611686018427387904"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

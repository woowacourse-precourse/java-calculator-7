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
    void 기본_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 하나의_피연산자만_사용() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 실수_사용() {
        assertSimpleTest(() -> {
            run("1.1:2:3");
            assertThat(output()).contains("결과 : 6.1");
        });
    }

    @Test
    void 커스텀_구분자와_실수_사용() {
        assertSimpleTest(() -> {
            run("//#\\n1.1#2#3");
            assertThat(output()).contains("결과 : 6.1");
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
    void 커스텀_구분자_1자_이상_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//ab\\n1;2ab3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_2개_이상_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n//@\\n1;2@3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 허용되지_않는_커스텀_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//+\\n1:2+3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자를_커스텀_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 지정하지_않은_커스텀_구분자_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자를_커스텀_구분자로_사용_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//:\\n1:2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

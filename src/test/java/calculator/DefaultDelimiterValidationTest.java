package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DefaultDelimiterValidationTest extends NsTest {
    @Test
    void 기본_구분자_성공_테스트1() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트2() {
        assertSimpleTest(() -> {
            run("1:2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_성공_테스트3() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_실패_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1:2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_실패_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1-1:2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_실패_테스트3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> run("12-1:2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_실패_테스트4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10,1:2,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_실패_테스트5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("10,1:2:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

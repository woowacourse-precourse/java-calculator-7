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
    void 커스텀_구분자와_기본_구분자_함께_사용() {
        assertSimpleTest(() -> {
            run("//;\\n3:5:4,6;2");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 다중_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//#\\n//%\\n//&\\n1&9#2%33#14");
            assertThat(output()).contains("결과 : 59");
        });
    }

    @Test
    void 다중_커스텀_구분자와_기본_구분자_함께_사용() {
        assertSimpleTest(() -> {
            run("//#\\n//%\\n//&\\n1&9#2%33#14:11,4:3");
            assertThat(output()).contains("결과 : 77");
        });
    }

    @Test
    void 예외_테스트_1_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2_1_빈값_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2_2_빈값_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",3:4,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_2_3_빈값_3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2,3:,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3_1_문자_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3,s"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3_2_문자_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,3s,4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_4_커스텀_구분자_닫히지_않음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;3,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_5_다중_커스텀_구분자_닫히지_않음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n//@3,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

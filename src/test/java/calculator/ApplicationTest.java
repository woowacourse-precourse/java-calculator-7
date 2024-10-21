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
    void 아무것도_입력안하면_0() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_입력_1() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본_입력_2() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("result : 6");
        });
    }

    @Test
    void 기본_입력_3() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("result : 6");
        });
    }

    @Test
    void int_최대값_테스트() {
        assertSimpleTest(() -> {
            run("2147483647,1");
            assertThat(output()).contains("result : 2147483648");
        });
    }

    @Test
    void long_최대값_테스트() {
        assertSimpleTest(() -> {
            run("9223372036854775807,1");
            assertThat(output()).contains("result : 9223372036854775808");
        });
    }

    @Test
    void 숫자_0이_포함되면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수가_포함되면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;[\\n1;2,3:4[5");
            assertThat(output()).contains("result : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4;5");
            assertThat(output()).contains("result : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용4() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4;5");
            assertThat(output()).contains("result : 15");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

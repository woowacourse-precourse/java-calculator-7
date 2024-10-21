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
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("10,20:10");
            assertThat(output()).contains("결과 : 40");
        });
    }

    @Test
    void 빈문자열_입력() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 예외_커스텀_구분자_크기_2이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;@\\n1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_빈문자() {
        assertSimpleTest(() -> {
            run("// \\n1 2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 예외_커스텀_구분자로_특수문자_사용() {
        assertSimpleTest(() -> {
            run("//|\\n1|2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//*\\n1*2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//+\\n1+2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//(\\n1(2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//)\\n1)2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//[\\n1[2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//]\\n1]2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//{\\n1{2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//}\\n1}2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//.\\n1.2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//^\\n1^2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//$\\n1$2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//\\\\n1\\2");
            assertThat(output()).contains("결과 : 3");
        });

        assertSimpleTest(() -> {
            run("//&\\n1&2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

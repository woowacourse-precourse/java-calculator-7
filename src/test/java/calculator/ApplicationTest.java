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
    void 기본_구분자_사용1() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용2() {
        assertSimpleTest(() -> {
            run("1,2:3:");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자와_기본_구분자_혼용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//[\\n1[2[3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//test\\n1test2test3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,2,,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_예외_테스트1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//4\\n1424344"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자_예외_테스트2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//test"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_예외_테스트1() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,a,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_예외_테스트2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("test"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

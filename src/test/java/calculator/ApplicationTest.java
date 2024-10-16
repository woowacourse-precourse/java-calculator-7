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
    void 일반_구분자_사용1() {
        assertSimpleTest(() -> {
            run("8,5,7");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @Test
    void 일반_구분자_사용2() {
        assertSimpleTest(() -> {
            run("3,15;3");
            assertThat(output()).contains("결과 : 21");
        });
    }

    @Test
    void 일반_구분자_사용3() {
        assertSimpleTest(() -> {
            run("21;1,2");
            assertThat(output()).contains("결과 : 24");
        });
    }

    @Test
    void 일반_구분자_사용4() {
        assertSimpleTest(() -> {
            run("11;12;13");
            assertThat(output()).contains("결과 : 36");
        });
    }

    @Test
    void 일반_구분자_사용5() {
        assertSimpleTest(() -> {
            run("13,2,3;6,3;17;32;12,1;1");
            assertThat(output()).contains("결과 : 90");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

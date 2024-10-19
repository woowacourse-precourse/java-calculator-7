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
    void 쉼표_구분자() {
        assertSimpleTest(() -> {
            run("1,5");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 비정상적인_구분자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(",,,,,1,1,1,1,1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 비정상적인_구분자2() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,1,1,1,1,,,,,"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 비정상적_구분자의_돌돌이() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException(",:,:,:,:,:,:"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자_한개() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 빈_문자() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 빈_문자2() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 가짜_커스텀_구분자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//?\\b1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

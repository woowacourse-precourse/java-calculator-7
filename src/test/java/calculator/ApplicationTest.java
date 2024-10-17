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
    void 연속된_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,,2::3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_연속된_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;!\\n1;;2!!3::4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 두_자리_이상_숫자() {
        assertSimpleTest(() -> {
            run("1,20,300:4000");
            assertThat(output()).contains("결과 : 4321");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

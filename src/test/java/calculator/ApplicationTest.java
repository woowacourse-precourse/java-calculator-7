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
    void 커스텀구분자와일반구분자를함께사용() {
        assertSimpleTest(() -> {
            run("//@\\n1:2@3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 이스케이프문자를커스텀구분자로사용() {
        assertSimpleTest(() -> {
            run("//*\\n1:2*3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 줄바꿈문자() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백문자() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

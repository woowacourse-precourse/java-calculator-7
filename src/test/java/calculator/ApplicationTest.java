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
    void 숫자로만_이루어진_문자열_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111111"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자로만_이루어진_문자열_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(":,,:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 공백을_0으로_처리() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 부적절한_문자_포함여부_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("!:2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

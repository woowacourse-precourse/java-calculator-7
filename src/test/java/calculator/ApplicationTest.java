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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 커스텀_구분자_2번이상() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;3//"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void long보다_큰숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("9223372036854775808"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 마이너스_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("2:-1:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

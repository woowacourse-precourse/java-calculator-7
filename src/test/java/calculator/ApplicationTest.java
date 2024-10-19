package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3,4:5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 구분자_에러_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_하나_테스트() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_에러_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(";\\n1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void Long_범위_초과_숫자_연산_테스트() {
        assertSimpleTest(() -> {
            run("123456789123456789123456789123456789123456789:123456789123456789123456789123456789123456789");
            assertThat(output()).contains("결과 : 246913578246913578246913578246913578246913578");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void validateEmptyInput() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });

        assertSimpleTest(() -> {
            run("100");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void validateNoDelimiter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class);
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("123;123"));
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("123,123"));
        });
        assertSimpleTest(() -> {
            assertThatNoException().isThrownBy(() -> runException("123;12,3"));
        });
    }


    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("-1,2,3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

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
    void 추가_예외_테스트() {
        assertSimpleTest(() -> {
            run("//;432\\n1;4328");
            assertThat(output()).contains("결과 : 9");
        });
    }

    @Test
    void 추가_예외_테스트_2() {
        assertSimpleTest(() -> {
            run("//;432\\n1;4328:46,23");
            assertThat(output()).contains("결과 : 78");
        });
    }

    @Test
    void 예외_테스트_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1,2,3;;5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//;432n1;4328:46,23"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

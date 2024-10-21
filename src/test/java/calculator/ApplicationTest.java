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
    void 커스텀_구분자_입력_및_사용하는_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1.2;3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자가_문자열_시작에_존재하지_않는_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("12;3//;\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 커스텀_구분자가_2개이상인_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//!@;\\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 숫자가_입력되지_않았을때의_테스트() {
        assertSimpleTest(() -> {
            run("//!\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자선언이_2개이상_존재하는_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//!\\n//?\n123"))
                    .isInstanceOf(IllegalArgumentException.class);
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

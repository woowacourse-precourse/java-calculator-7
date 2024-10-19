package calculator;

import calculator.global.constant.ErrorMessage;
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
    void 등록되지_않은_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n1@2"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
        });
    }

    @Test
    void 커스텀_구분자_두번_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1//@\\n2@3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_길이가_2() {
        assertSimpleTest(() -> {
            run("//;;\\n1;;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

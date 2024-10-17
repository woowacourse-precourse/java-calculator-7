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
    void 문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자만_입력_예외_테스트() {
        assertSimpleTest(() -> {
            run("910");
            assertThat(output()).contains("결과 : 910");
        });
    }

    @Test
    void 빈문자_입력_예외_테스트() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자만_입력_예외_테스트() {
        assertSimpleTest(() -> {
            run(":");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자가_여러개인_입력_예외_테스트() {
        assertSimpleTest(() -> {
            run("4,5//%\\n6%7//,\\n8,9");
            assertThat(output()).contains("결과 : 147");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomApplicationTest extends NsTest {
    @Test
    void int범위초과_테스트() {
        assertSimpleTest(() -> {
            run("2147483647:2147423647,347483647");
            assertThat(output()).contains("결과 : 4642390941");
        });
    }

    @Test
    void 추가테스트_정수일반연산() {
        assertSimpleTest(() -> {
            run("1,2,10:5");
            assertThat(output()).contains("결과 : 18");
        });
    }

    @Test
    void 추가테스트_커스텀구분자1() {
        assertSimpleTest(() -> {
            run("//abc\\n1a2b3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 추가테스트_커스텀구분자2() {
        assertSimpleTest(() -> {
            run("// \\n1 2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 추가테스트_커스텀구분자3() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//abc\\n1a2b3c"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀영역_내_커스텀영역선언자() {
        assertSimpleTest(() -> {
            run("//\\\\n1\\2\\3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 소수입력_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("3,10.2:2:5"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

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
    void 한글자_테스트() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 큰수_테스트() {
        assertSimpleTest(() -> {
            run("1,10:100");
            assertThat(output()).contains("결과 : 111");
        });
    }

    @Test
    void 구분자로_끝_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3,");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 구분자로_숫자_테스트() {
        assertSimpleTest(() -> {
            run("//3\\n132,2313");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 개행_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//\\n\\n1\\n2\\n"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 공백_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(" "))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 커스텀미입력_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//\\n1,2,3"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
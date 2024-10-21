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
    void 한글자_이상의_커스텀_구분자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//l;\n1;3;2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_커스텀_구분자_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//7\n2723"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\n\n27\n23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_기본_구분자_모두_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;5;2,1:4");
            assertThat(output()).contains("결과 : 13");
        });
    }

    @Test
    void 구분자_대시_사용() {
        assertSimpleTest(() -> {
            run("//-\\n2-7-2-3");
            assertThat(output()).contains("결과 : 14");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

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
    void 기본구분자_콤마() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본구분자_콤마_콜론() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본구분자_빈문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본구분자_빈문자열_포함() {
        assertSimpleTest(() -> {
            run("1::2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 커스텀구분자_세미콜론() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자_기본구분자_혼합() {
        assertSimpleTest(() -> {
            run("//|\\n1|2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀구분자_숫자하나() {
        assertSimpleTest(() -> {
            run("//;\\n5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 커스텀구분자_빈문자열() {
        assertSimpleTest(() -> {
            run("//&\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 오류_음수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_제로() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,0,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_커스텀구분자_음수() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\\n-1;2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_숫자아닌값() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,a,2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_커스텀구분자_양식() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;1;2"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_커스텀구분자_여러개() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//?!\\n1"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_커스텀구분자_공백() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\n"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 오류_커스텀구분자_숫자() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//1\n1,12"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 입력_공백_제거() {
        assertSimpleTest(() -> {
            run("1 , 2,     3");
            assertThat(output()).contains("결과 : 6");
        });
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

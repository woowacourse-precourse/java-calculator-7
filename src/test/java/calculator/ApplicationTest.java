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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 정상입력_테스트_빈문자열() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정상입력_테스트_커스텀_복잡() {
        assertSimpleTest(() -> {
            run("//|\\n2|5|10");
            assertThat(output()).contains("결과 : 17");
        });
    }

    @Test
    void 정상입력_테스트_커스텀_스페이스바() {
        assertSimpleTest(() -> {
            run("// \\n10 20 30");
            assertThat(output()).contains("결과 : 60");
        });
    }

    @Test
    void 예외_테스트_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2: "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중간_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//|\\n2| |5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_구분자_형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//[::]\\n1::2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_숫자_누락() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

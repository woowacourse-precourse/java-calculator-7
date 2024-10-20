package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class MyApplicationTest extends NsTest {
    @Test
    void 공백_입력_테스트() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void null_입력_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 구분자_없이_숫자만_입력_테스트() {
        assertSimpleTest(() -> {
            run("12345");
            assertThat(output()).contains("결과 : 12345");
        });
    }

    @Test
    void 실수_입력_테스트() {
        assertSimpleTest(() -> {
            run("1.5,5,6");
            assertThat(output()).contains("결과 : 12.5");
        });
    }

    @Test
    void 긴_커스텀_구분자_입력_테스트() {
        assertSimpleTest(() -> {
            run("//:::\\n1:::2:::3:::5");
            assertThat(output()).contains("결과 : 11");
        });
    }

    @Test
    void 예외_테스트_구분자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",:,"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//b\\nb"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_지시자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_지시자2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_지시자3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("///;\\n1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_지시자4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\\n;//1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//4\\n142435"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_없음() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n12435"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("// \\n1 2 3 5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀구분자_점() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//.\\n1.2.3.5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

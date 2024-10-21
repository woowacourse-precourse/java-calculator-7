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
    void 길이가_0인_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자만_입력() {
        assertSimpleTest(() -> {
            run(",,:,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자_외_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2,a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_중첩() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("////;\\n\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//\\n1,2:3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자를_공백문자로_입력() {
        assertSimpleTest(() -> {
            run("// \\n1 2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자를_문자로_입력() {
        assertSimpleTest(() -> {
            run("//a\\n1,2a3:4a5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자를_숫자로_입력() {
        assertSimpleTest(() -> {
            run("//1\\n213:415");
            assertThat(output()).contains("결과 : 14");
        });
    }

    @Test
    void 커스텀_구분자의_접두사_미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2a\\n3a4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자의_접미사_미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2//a3a4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

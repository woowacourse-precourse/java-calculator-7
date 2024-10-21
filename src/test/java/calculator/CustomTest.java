package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomTest extends NsTest {

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 쉼표_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 콜론_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 쉼표와_콜론_혼합() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 잘못된_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 커스텀_구분자_잘못된_형식() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Test
    void 잘못된_구분자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\n1;2;abc"))
                        .isInstanceOf(IllegalArgumentException.class)

        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

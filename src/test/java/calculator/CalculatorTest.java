package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


class CalculatorTest extends NsTest {

    @Test
    void 특수문자_커스텀구분자사용() {
        assertSimpleTest(() -> {
            run("//.\\n1.2.3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈문자열_입력() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 음수가_포함된_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,-2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
            ;
        });
    }

    @Test
    void 숫자_이외의_문자가_포함된_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,-2,a"))
                    .isInstanceOf(IllegalArgumentException.class);

        });
    }

    @Test
    void 커스텀구분자_뒤에_줄바꿈이_없는_경우() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//.1;2"))
                    .isInstanceOf(IllegalArgumentException.class);

        });
    }

    @Test
    void 숫자가_없는_커스텀구분자_입력() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀구분자_없이_특수문자_사용된_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1.1;2"))
                    .isInstanceOf(IllegalArgumentException.class);
            ;
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

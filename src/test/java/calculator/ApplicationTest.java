package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본값_입력_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본값_입력_테스트2() {
        assertSimpleTest(() -> {
            run("1,2:3:4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//;\\n1,2;3:4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//asd\\n1asd2asd3asd4asd5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_숫자_구분자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//2\\n122232425"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_형식_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈값_입력_형식_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,:::"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 빈값_입력_형식_예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,2,::34:"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

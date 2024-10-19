package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 빈_문자열_입력_결과0_성공() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백만_입력_결과0_성공() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_콜론만_사용_성공() {
        assertSimpleTest(() -> {
            run("11:22:33");
            assertThat(output()).contains("결과 : 66");
        });
    }

    @Test
    void 기본_구분자_쉼표만_사용_성공() {
        assertSimpleTest(() -> {
            run("11,22,33");
            assertThat(output()).contains("결과 : 66");
        });
    }

    @Test
    void 기본_구분자_둘다_사용_성공() {
        assertSimpleTest(() -> {
            run("11,22:33");
            assertThat(output()).contains("결과 : 66");
        });
    }

    @Test
    void 기본_구분자_문자열_앞뒤공백_제거_성공() {
        assertSimpleTest(() -> {
            run(" 11,22:33 ");
            assertThat(output()).contains("결과 : 66");
        });
    }

    @Test
    void 기본_구분자_문자열_중간공백_제거_성공() {
        assertSimpleTest(() -> {
            run("11, 22: 33");
            assertThat(output()).contains("결과 : 66");
        });
    }

    @Test
    void 기본_구분자_예외_음수_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-11,22:33"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기본_구분자_예외_구분자가_아닌_문자_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11,*22:33"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_단독_사용() {
        assertSimpleTest(() -> {
            run("//;\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자와_기본구분자_섞어서_사용() {
        assertSimpleTest(() -> {
            run("//;\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_숫자이면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//1\n1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 여러_개의_커스텀_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//!@\n1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_공백이면_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("// \n1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

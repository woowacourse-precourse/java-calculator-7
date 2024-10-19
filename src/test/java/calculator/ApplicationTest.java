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
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

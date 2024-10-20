package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 입력_메세지_출력_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
        });
    }

    @Test
    void 입력_정상_처리_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 구분자_패턴_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//;\n1,2;3"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_쉼표_사용_테스트() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_콜론_사용_테스트() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 줄바꿈_커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//\\n\\n1\\n2\\n3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 여러_줄바꿈_커스텀_구분자_사용_테스트() {
        assertSimpleTest(() -> {
            run("//\\n\\n\\n1\\n\\n2\\n\\n3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자_0_처리_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 큰_정수_처리_테스트() {
        assertSimpleTest(() -> {
            run("1000000,2000000");
            assertThat(output()).contains("결과 : 3000000");
        });
    }

    @Test
    void 깊은_소수_처리_테스트() {
        assertSimpleTest(() -> {
            run("0.0000001,0.0000002");
            assertThat(output()).contains("결과 : 0.0000003");
        });
    }

    @Test
    void 정수_출력_테스트() {
        assertSimpleTest(() -> {
            run("1,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 소수_출력_테스트() {
        assertSimpleTest(() -> {
            run("1.5,2.3");
            assertThat(output()).contains("결과 : 3.8");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

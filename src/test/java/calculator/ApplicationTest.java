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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//.\\n1.2.3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 공백_문자열_입력() {
        assertSimpleTest(() -> {
            run("    ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 양수_하나_입력() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 영_포함된_숫자_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("1,2,0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양수가 아닌 값이 있습니다.");
        });
    }

    @Test
    void 음수_포함된_숫자_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 숫자 형식입니다.");
        });
    }

    @Test
    void 여러_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 커스텀_구분자_잘못된_형식() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//\\n1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 숫자 형식입니다.");
        });
    }

    @Test
    void 커스텀_구분자_여러_개() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//$%\n1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 숫자 형식입니다.");
        });
    }

    @Test
    void 커스텀_구분자_반복() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("//.\n//;\n1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 숫자 형식입니다.");
        });
    }

    @Test
    void 영_하나_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("0"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양수가 아닌 값이 있습니다.");
        });
    }

    @Test
    void 음수_하나_입력() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("-3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("잘못된 숫자 형식입니다.");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

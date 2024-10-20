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
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//!\\n1!2!3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_2개_사용() {
        assertSimpleTest(() -> {
            run("//!;\\n1!2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_3개_사용() {
        assertSimpleTest(() -> {
            run("//!;^\\n1!2;3^4");
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    void 커스텀_구분자_4개_사용() {
        assertSimpleTest(() -> {
            run("//!;^@\\n1!2;3^4@5");
            assertThat(output()).contains("결과 : 15");
        });
    }
    @Test
    void 커스텀_구분자와_기본_구분자_함께_사용() {
        assertSimpleTest(() -> {
            run("//!\\n1!2,3,4:");
            assertThat(output()).contains("결과 : 10");
        });
    }
    @Test
    void 커스텀_구분자_숫자안_공백_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1; 2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 공백_처리_테스트() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }
    @Test
    void 구분자를_가지지않는_단일값_테스트() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }
    @Test
    void 음수_예외처리_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 커스텀_구분자_잘못_사용() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/!\n1!2!3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

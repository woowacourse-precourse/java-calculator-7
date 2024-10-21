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
    void 기본_구분자_쉼표_콜론_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 하나의_숫자_입력() {
        assertSimpleTest(() -> {
            run("5");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 여러개의_숫자_입력_기본_구분자() {
        assertSimpleTest(() -> {
            run("1,2,3,4,5");
            assertThat(output()).contains("결과 : 15");
        });
    }

    @Test
    void 커스텀_구분자_여러개_입력() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3;4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 잘못된_구분자_형식_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("구분자 형식이 올바르지 않습니다")
        );
    }

    @Test
    void 잘못된_문자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,a,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("유효하지 않은 값이 포함되어 있습니다")
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

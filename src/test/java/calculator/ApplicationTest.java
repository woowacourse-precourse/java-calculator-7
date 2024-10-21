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
    void 기본_구분자만_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자만_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본과_커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1;2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_입력_처리() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 연속된_구분자_처리() {
        assertSimpleTest(() -> {
            run("1,,2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 공백이_있는_입력_처리() {
        assertSimpleTest(() -> {
            run(" 1 , 2 , 3 ");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("-1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수는 입력할 수 없습니다");
        });
    }

    @Test
    void 유효하지_않은_숫자_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1,a,3"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자 변환에 실패했습니다");
        });
    }

    @Test
    void 유효하지_않은_구분자_형식_예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//\\\n456n4"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("유효하지 않은 구분자 형식입니다");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

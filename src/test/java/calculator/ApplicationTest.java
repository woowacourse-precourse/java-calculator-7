package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
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
    void 큰수_입력() {
        assertSimpleTest(() -> {
            run("11111111111111111111:22222222222222222222");
            assertThat(output()).contains("결과 : 33333333333333333333");
        });
    }

    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 음수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수가 입력되었습니다")
        );
    }

    @Test
    void 구분자_외_문자열_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2!3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("입력 문자열에는 숫자만 포함되어야 합니다")
        );
    }

    @Test
    void 커스텀_구분자_양식_오류_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\x1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자 지정 양식이 잘못되었습니다")
        );
    }

    @Test
    void 커스텀_구분자_길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n1;;2;;3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("커스텀 구분자가 존재하지 않거나 2자 이상입니다")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

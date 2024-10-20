package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @DisplayName("? 구분자 사용 테스트")
    @Test
    void 커스텀_구분자_사용1() {
        assertSimpleTest(() -> {
            run("//?\\n2?3?5?10");
            assertThat(output()).contains("결과 : 20");
        });
    }

    @DisplayName("* 구분자 사용 테스트")
    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("//*\\n3*9*10");
            assertThat(output()).contains("결과 : 22");
        });
    }

    @DisplayName("빈 문자열 입력 시 결과는 0")
    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run();
            assertThat(output()).contains("결과 : 0");
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
    @DisplayName("숫자 대신 문자가 들어갔을 때 테스트")
    void 예외_테스트1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ㅁ,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("잘못된 구분자 정의 시 예외 발생")
    void 예외_테스트2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;1;2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("커스텀 구분자 ';' 사용 - 입력값 '1'")
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("커스텀 구분자 '-' 사용 - 입력값 '1-2'")
    void 커스텀_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("//-\\n1-2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    @DisplayName("기본 구분자 ','와 ':' 사용 - 입력값 '1,2,3:4'")
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2,3:4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    @DisplayName("기본 구분자 ','와 ':' 사용 - 입력값 '1'")
    void 기본_구분자_사용_2() {
        assertSimpleTest(() -> {
            run("1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    @DisplayName("기본 구분자 ','와 ':' 사용 - 입력값 ''")
    void 기본_구분자_사용_3() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("음수 입력 예외 처리 - 입력값 '-1,2,3'")
    void 예외_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("-1,2,3")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 예외 처리 - 입력값 '//;n-1,2,3'")
    void 예외_테스트_2() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("//;n-1,2,3")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 예외 처리 - 입력값 ';\\n-1,2,3'")
    void 예외_테스트_3() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(";\\n-1,2,3")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Test
    @DisplayName("입력값을 초과했을 때 예외 처리")
    void 예외_테스트_4() {
        assertSimpleTest(() -> {
            run("2147483648");
            assertThat(output()).contains("결과 : 2147483647");
        });
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("2147483648")).isInstanceOf(
                IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

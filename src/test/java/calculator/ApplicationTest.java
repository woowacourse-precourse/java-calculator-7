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

        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용_정규표현식_메타데이터_이스케이프처리() {
        assertSimpleTest(() -> {
            run("//+\\n1+2+3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_기본_구분자_혼합사용() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3;4,5;6:7,8,9;10");
            assertThat(output()).contains("결과 : 55");
        });
    }

    @Test
    void 기본_구분자_콜론_입력() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_문자열_처리() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 정수자료형_최대값_계산() {
        assertSimpleTest(() -> {
            run("1000000000,1000000000,147483647");
            assertThat(output()).contains("결과 : 2147483647");
        });
    }

    @Test
    void 입력값이_정수형_자료범위_초과() {
        assertThatThrownBy(() -> runException("2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 값이 정수의 범위를 초과합니다");
    }

    @Test
    void 계산결과가_정수형_자료범위_초과() {
        assertThatThrownBy(() -> run("2000000000,2000000000"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("integer overflow");
    }

    @Test
    void 예외_테스트_음수_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("음수는 허용되지 않습니다")
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_숫자미입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//test\\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_커스텀_구분자_숫자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//3\\n132333"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

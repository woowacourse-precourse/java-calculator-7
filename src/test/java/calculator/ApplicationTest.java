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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // Given: "-1, -2, -3"
    // When: SumCalculator.sum(inputDTO)
    // Then: IllegalArgumentException
    @Test
    void 예외_테스트_음수만_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,-2,-3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // Given: 0
    // When: SumCalculator.sum(inputDTO)
    // Then: IllegalArgumentException
    @Test
    void 예외_테스트_문자열_0_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // Given: "\n"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    // 문제 입력 조건 중 "" => 0 에 해당하는 부분
    @Test
    void 동작_테스트_빈_문자열_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // Given: " "
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_공백_문자열_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // Given: "//1\n21212,212"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 10"
    @Test
    void 동작_테스트_커스텀_구분자를_숫자로_사용() {
        assertSimpleTest(() -> {
            run("//1\\n21212,212");
            assertThat(output()).contains("결과 : 10");
        });
    }

    // Given: "123"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 123"
    @Test
    void 동작_테스트_숫자만_입력() {
        assertSimpleTest(() -> {
            run("123");
            assertThat(output()).contains("결과 : 123");
        });
    }

    // Given: ","
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_구분자만_입력() {
        assertSimpleTest(() -> {
            run(",");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // Given: ",:,"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_구분자만_다수_입력() {
        assertSimpleTest(() -> {
            run(",:,");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // Given: "//;\\n"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_커스텀_구분자_지정만() {
        assertSimpleTest(() -> {
            run("//;\\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // Given: "//;\\n;"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_커스텀_구분자만_입력() {
        assertSimpleTest(() -> {
            run("//;\\n;");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // Given: "//;\\n;;;"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_커스텀_구분자만_다수_입력() {
        assertSimpleTest(() -> {
            run("//;\\n;;;");
            assertThat(output()).contains("결과 : 0");
        });
    }

    // Given: "//;\\n;,:;"
    // When: SumCalculator.sum(inputDTO)
    // Then: "결과 : 0"
    @Test
    void 동작_테스트_기본과_커스텀_구분자들만_입력() {
        assertSimpleTest(() -> {
            run("//;\\n;,:;");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

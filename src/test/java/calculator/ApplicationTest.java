package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

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
        assertSimpleTest(() -> {
            run("-1,2,3");
            assertThat(output()).contains("음수는 입력할 수 없습니다: -1");
        });
    }

    @Test
    void 음수_입력_예외() {
        assertSimpleTest(() -> {
            run("-1,2,3");
            assertThat(output()).contains("음수는 입력할 수 없습니다: -1");
        });
    }

    @Test
    void 일반_커스텀_구분자_함께_사용() {
        assertSimpleTest(() -> {
            run("1,2:4");
            assertThat(output()).contains("결과 : 7");
        });
    }

    @Test
    void 문자_입력_예외() {
        assertSimpleTest(() -> {
            run("1,a,3");
            assertThat(output()).contains("유효하지 않은 숫자가 포함되어 있습니다: a");
        });
    }

    @Test
    void 입력_없음() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자만_입력() {
        assertSimpleTest(() -> {
            run("1234");
            assertThat(output()).contains("결과 : 1234");
        });
    }

    @Test
    void 긴_숫자_입력() {
        assertSimpleTest(() -> {
            run("1,999999999999999999999999");
            assertThat(output()).contains("유효하지 않은 숫자가 포함되어 있습니다: 999999999999999999999999");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
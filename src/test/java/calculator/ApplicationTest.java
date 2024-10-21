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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 기본_구분자_쉼표와_콜론_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 숫자가_아닌_입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("유효하지 않은 숫자 형식입니다.")
        );
    }

    @Test
    void 여러_숫자_입력() {
        assertSimpleTest(() -> {
            run("4,5,6,7");
            assertThat(output()).contains("결과 : 22");
        });
    }

    @Test
    void 커스텀_구분자_여러_문자_사용() {
        assertSimpleTest(() -> {
            run("//***\\n1***2***3");
            assertThat(output()).contains("결과 : 6");
        });
    }
}

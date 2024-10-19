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
    void 커스텀_구분자_형식_중간에_사이에_1개가_아니면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;{\\n1;2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 구분자 형식입니다.")
        );
    }

    @Test
    void 숫자형식_변환중_잘못된_형식이면_예외가_발생한다() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1q,2,3:4"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 숫자 입니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

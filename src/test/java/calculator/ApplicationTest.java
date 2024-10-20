package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 쉼표_구분자를_사용할_수_있어요() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 콜론_구분자를_사용할_수_있어요() {
        assertSimpleTest(() -> {
            run("1:2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 쉼표와_콜론_구분자를_같이_사용할_수_있어요() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자를_사용할_수_있어요() {
        assertSimpleTest(() -> {
            run("//;\\n1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 잘못된_구분자를_사용하면_오류가_발생해요() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2;3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수를_사용하면_오류가_발생해요() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

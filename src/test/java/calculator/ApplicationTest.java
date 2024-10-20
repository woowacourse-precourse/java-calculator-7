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

    @Test
    void 구분자와_공백문자_숫자포함_사용() {
        assertSimpleTest(() -> {
            run("1 , 1");
            assertThat(output()).contains("결과 : 2");
        });
    }


    @Test
    void 공백문자만_사용() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 빈문자열만_사용() {
        assertSimpleTest(() -> {
            run("  ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 숫자가_0인경우_예외() {
        assertThatThrownBy(() -> runException("0,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

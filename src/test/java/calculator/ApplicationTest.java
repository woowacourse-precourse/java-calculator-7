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
    void 구분자가_없는_경우() {
        assertSimpleTest(() -> {
            run("12345");
            assertThat(output()).contains("결과 : 12345");
        });
    }

    @Test
    void 기본구분자만_존재하는_경우() {
        assertSimpleTest(() -> {
            run(",1::2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자만_존재하는_경우() {
        assertSimpleTest(() -> {
            run("//\"\\n0\"3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 기본구분자와_커스텀구분자가_모두_사용된_경우() {
        assertSimpleTest(() -> {
            run("//#\\n3#2:,0");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 구분자로_선언되지_않은_문자가_입력된_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//&\\n1%2:3&2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 계산가능한_범위에서_벗어난_값을_입력한_경우() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("11223344556677889900"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

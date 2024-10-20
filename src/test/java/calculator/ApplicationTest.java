package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.Separator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    /**
     * 테스트 종료 후 Separator의 구분자를 초기화한다.
     */
    @AfterAll
    static void tearDown() {
        Separator.getSeparators().clear();
        Separator.addSeparator(',');
        Separator.addSeparator(':');
    }

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
}

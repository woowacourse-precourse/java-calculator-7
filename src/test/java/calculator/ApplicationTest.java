package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    // 문제에서 제공한 테스트 2개
    @Test
    void usingCustomDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void exceptionTest() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    // 개인 테스트
    @Test
    void getCustomDelimiter(){
        assertSimpleTest(() -> {
           run("//;\\n");
           assertThat(output()).contains(";");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest2 extends NsTest {
    @Test
    void 문자_1개일_경우() {
        assertSimpleTest(() -> {
            run("//&\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 문자_여러개일_경우() {
        assertSimpleTest(() -> {
            run("//&%\\n1&%1,2");
            assertThat(output()).contains("결과 : 4");
        });
    }

    @Test
    void 같은_문자_여러개일_경우() {
        assertSimpleTest(() -> {
            run("//%%\\n1%%2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 메타문자일_경우() {
        assertSimpleTest(() -> {
            run("//[^\\n1[^2");
            assertThat(output()).contains("결과 : 3");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

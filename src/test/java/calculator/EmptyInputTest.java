package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class EmptyInputTest extends NsTest {
    @Test
    void 빈_문자열_입력() {
        assertSimpleTest(() -> {
            run(""); // 빈 문자열 입력
            assertThat(output()).contains("결과 : 0");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

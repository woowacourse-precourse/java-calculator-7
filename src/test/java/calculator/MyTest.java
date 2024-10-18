package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class MyTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }


    @Test
    void 커스텀_구분자에_정규표현식_사용() {
        assertSimpleTest(() -> {
            run("//|\\n1|2|3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자가_여러문자() {
        assertSimpleTest(() -> {
            run("//;;\\n1;;2;;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
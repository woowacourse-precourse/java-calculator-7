package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {

    @Test
    void testBasicDelimiters() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });

        assertSimpleTest(() -> {
            run("4:5:6");
            assertThat(output()).contains("결과 : 15");
        });

        assertSimpleTest(() -> {
            run("1,2:3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void testCustomDelimiter() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }


    @Test
    void testException() {
        assertSimpleTest(() -> {
            run("-1,2,3");
            assertThat(output()).contains("음수는 허용되지 않습니다: -1");
        });
    }

    @Test
    void testSpace() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    /*@Test
    void testNull() {
        assertSimpleTest(() -> {
            run("");
            assertThat(output()).contains("결과 : 0");
        });
    }*/

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

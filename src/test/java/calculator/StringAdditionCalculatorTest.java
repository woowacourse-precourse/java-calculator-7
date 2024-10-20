package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class StringAdditionCalculatorTest extends NsTest {

    @Test
    void 기본구분자_숫자추출_테스트() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자_숫자추출_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본구분자_연속구분자_테스트() {
        assertSimpleTest(() -> {
            run(",1,:,:2::3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀구분자_연속구분자_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n;1;;9;");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 공백_0반환_테스트() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀구분자_0반환_테스트() {
        assertSimpleTest(() -> {
            run("//;\\n   ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

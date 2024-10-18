package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.Calculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 공백입력시_반환값_테스트() {
        Calculator calculator = new Calculator();
        int result = calculator.add("");

        Assertions.assertEquals(0, result);
    }

    @Test
    void null값_처리_테스트() {
        Calculator calculator = new Calculator();
        int result = calculator.add(null);
        Assertions.assertEquals(0, result);
    }

    @Test
    void 기본_구분자만_사용한_더하기() {
        assertSimpleTest(() -> {
            run("1,2,3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_구분자_조합_사용한_더하기_() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀구분자_처리_테스트() {
        Calculator calculator = new Calculator();
        int result = calculator.add("//;\\n1,2;3");
        Assertions.assertEquals(6, result);
    }

    @Test
    void 커스텀_구분자가_맨앞에_존재하지않을때() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.add("1;2,3//;\\n"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 아닌 값이 있습니다");
    }

    @Test
    void 커스텀_구분자로_지정되지_않은_입력값_예외테스트() {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.add("1,2;3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구분자가 아닌 값이 있습니다");
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

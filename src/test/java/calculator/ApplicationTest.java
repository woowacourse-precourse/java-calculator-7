package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.model.Calculator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
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
    void 기본_구분자_사용() {
        int result = Calculator.calculate("100,2:5");
        Assertions.assertEquals(result, 107);

        result = Calculator.calculate("1,2:3");
        Assertions.assertEquals(result, 6);

        result = Calculator.calculate("");
        Assertions.assertEquals(result, 0);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void nullInputTest() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("//\\n1,2"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 빈칸(\"\")은 구분자가 될 수 없습니다.");
    }

    @Test
    void 숫자_구분자_예외_테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("//2\\n1,2"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 구분자에는 숫자를 포함할 수 없습니다.");
    }

    @Test
    void 구분자_외_문자_예외_테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("//;\\n1,2;3 5"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 입력 문자열은 " +
                "구분자 외 다른 문자를 포함할 수 없습니다.");
    }

    @Test
    void 입력포맷_예외_테스트() {
        IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("  //;\\n1,2;35"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 입력 포맷을 확인해주세요.");

        e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("  1,2;35"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 입력 포맷을 확인해주세요.");

        e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("/;\\n1,2;35"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 입력 포맷을 확인해주세요.");

        e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate("//;\n1,2;3"));
        Assertions.assertEquals(e.getMessage(), "잘못된 입력입니다. 입력 포맷을 확인해주세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

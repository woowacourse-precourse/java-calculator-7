package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {


    @Test
    void 입력_받기() {
        // given
        String input = "//;\\n1";

        // when
        CalculationService service = new CalculationService();
        Calculation calculation = new Calculation();
        // Calculation 객체를 넣으면 -> rawValue 값을 인풋값으로 설정
        service.getInputValues(calculation, input);

        // then
        List<Integer> expectedValue = new ArrayList<>();
        expectedValue.add(1);
        assertThat(calculation.getRawValue()).isEqualTo(expectedValue);
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

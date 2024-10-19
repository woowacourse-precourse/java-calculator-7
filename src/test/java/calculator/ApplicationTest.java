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
        Calculation calculation = new Calculation();
        CalculationService service = new CalculationService(calculation);
        // Calculation 객체를 넣으면 -> rawValue 값을 인풋값으로 설정
        service.getInputValues(input);

        // then
        List<Integer> expectedValue = new ArrayList<>();
        expectedValue.add(1);
        assertThat(calculation.getRawValue()).isEqualTo(expectedValue);
    }


    @Test
    void 입력값_유효성_확인() {
        // 입력값 : //;\\n1;1
        // 1. \n 을 기준으로 두 리스트를 만듦
        // 2. 앞의 리스트는 // 이후 커스텀 구분자, 기존 구분자에 추가 : [',', ':', ';']
        // 3. 뒤의 리스트는 계산식 -> [1, 1]
        // 4. 유효하지 않는 경우
        // - // -> 시작을 이거로 만족하지 않을 경우
        // - 계산식에 -> 구분자 리스트에 포함 되지 않는 값이 있을경우

        // given
        String wrongInputCase1 = "/;\\n1";
        String wrongInputCase2 = "//;\\n1+2";
        Calculation calculation2 = new Calculation();
        CalculationService service = new CalculationService(calculation2);

        // when
        // 이 과정에서 임의로 잘못된 값을 설정
        calculation2.setRawValue = wrongInputCase1;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            service.validateInput();
        });
    }


    @Test
    void 에러_구분_및_출력() {
        // given
        String wrongInput = "//;\\n1+2";
        Calculation calculation = new Calculation();
        CalculationService service = new CalculationService(calculation);
        calculation.setRawValue(wrongInput);

        ExceptionHandler exceptionHandler = new ExceptionHandler();

        // when
        Class<IllegalArgumentException> error = IllegalArgumentException.class;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            exceptionHandler.handleException(error);
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

package calculator;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {


    @Test
    void 입력_받기() {
        // given
        String input = "//;\\n1";

        // when
        Calculator calculator = new Calculator();
        CalculatorService service = new CalculatorService(calculator);
        // Calculation 객체를 넣으면 -> rawValue 값을 인풋값으로 설정
        service.getInputValues(input);

        // then
        String expectedValue = "//;\\n1";
        assertThat(calculator.getRawValue()).isEqualTo(expectedValue);
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
        Calculator calculation2 = new Calculator();
        CalculatorService service = new CalculatorService(calculation2);

        // when
        // 이 과정에서 임의로 잘못된 값을 설정
        calculation2.setRawValue(wrongInputCase1);

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            service.validateInput();
        });
    }

    @Test
    void 에러_구분_및_출력() {
        // given
        String wrongInput = "//;\\n1+2";
        Calculator calculator = new Calculator();
        CalculatorService service = new CalculatorService(calculator);
        calculator.setRawValue(wrongInput);

        ExceptionHandler exceptionHandler = new ExceptionHandler();

        // when
        Class<IllegalArgumentException> error = IllegalArgumentException.class;

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            exceptionHandler.handleException(error);
        });

    }

    @Test
    void 입력값_숫자_추출() {
        // given
        String input = "//+\\n1+2:3,4";
        Calculator calculator = new Calculator();
        CalculatorService service = new CalculatorService(calculator);
        calculator.setRawValue(input);

        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);

        // when
        List<Integer> numberList = service.extractNumbersToList();

        // then
        assertThat(numberList).isEqualTo(expectedList);
    }

    @Test
    void 추출한_값_더하기() {
        // given
        String input = "//+\\n1+2:3,4";
        Calculator calculator = new Calculator();
        CalculatorService service = new CalculatorService(calculator);
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4);
        calculator.setProcessedValue(expectedList);

        // when
        int result = service.sumOfList();

        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 값_출력() {
        // given
        Calculator calculator = new Calculator();
        CalculatorService service = new CalculatorService(calculator);
        calculator.setSumValue(10);

        // when
        String output = service.printResult();

        // then
        assertThat(output).isEqualTo("결과 : 10");
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

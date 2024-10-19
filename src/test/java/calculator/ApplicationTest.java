package calculator;

import calculator.domain.Calculator;
import calculator.error.ExceptionHandler;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {

    private Calculator calculator;
    private ExceptionHandler exceptionHandler;
    private CalculatorService service;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        exceptionHandler = new ExceptionHandler();
        service = new CalculatorService(calculator, exceptionHandler);
    }

    @Test
    void 입력_받기() {
        // given
        String input = "//;\\n1";

        // when
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


        // when
        String[] wrongInputCases = new String[] {"/;\\n1;1", "//;\\\\n1;2", "1:2", "//t\\n1+1", "1+1:", "1--1"};

        // then
        for (String wrongInputCase : wrongInputCases) {
            service.setIsValid(true);
            calculator.setSeparators(new ArrayList<>(Arrays.asList(";", ",")));
            calculator.setRawValue(wrongInputCase);
            assertThrows(IllegalArgumentException.class, service::validateInput);
        }
    }

    @Test
    void 에러_구분_및_출력() {
        // given
        String wrongInput = "//;\\n1+2";
        calculator.setRawValue(wrongInput);

        // when
        IllegalArgumentException error = new IllegalArgumentException();

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            exceptionHandler.handleException(error);
        });
    }

    @Test
    void 입력값_숫자_추출() {
        // given
        String input = "1:2,3,4";
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
        String input = "//+\\n1+2:3+4+10";
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 10);

        calculator.setProcessedValue(expectedList);

        // when
        int result = service.sumOfList();

        // then
        assertThat(result).isEqualTo(20);
    }

    @Test
    void 값_출력() {
        // given
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

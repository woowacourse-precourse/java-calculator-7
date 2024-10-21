package calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class PlusCalculatorTest {


    @Test
    @DisplayName("더하기 연산 테스트 - 성공")
    void successPlusOperation() throws Exception {
        //given
        CalculatorService service = PlusCalculator.getInstance();
        List<String> input = List.of("123", "456", "789");
        int expect = 1368;

        //when
        int result = service.operation(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    @DisplayName("더하기 연산 테스트 - 실패(숫자 변환)")
    void failPlusOperationParseInt() throws Exception {
        //given
        CalculatorService service = PlusCalculator.getInstance();
        List<String> input = List.of("123", "Error", "789");

        //when & then
        Assertions.assertThatThrownBy(() -> service.operation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닌 값을 입력하였습니다.");

    }

    @Test
    @DisplayName("더하기 연산 테스트 - 실패(음수 입력)")
    void failPlusOperationNegativeNumber() throws Exception {
        //given
        CalculatorService service = PlusCalculator.getInstance();
        List<String> input = List.of("123", "-100", "789");

        //when & then
        Assertions.assertThatThrownBy(() -> service.operation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수가 아닌 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("더하기 연산 테스트 - 실패(0 입력)")
    void failPlusOperationZero() throws Exception {
        //given
        CalculatorService service = PlusCalculator.getInstance();
        List<String> input = List.of("123", "0", "789");

        //when & then
        Assertions.assertThatThrownBy(() -> service.operation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수가 아닌 값을 입력하였습니다.");
    }

    @Test
    @DisplayName("더하기 연산 테스트 - 실패(정수 범위 초과)")
    void failPlusOperationOverflow() throws Exception {
        //given
        CalculatorService service = PlusCalculator.getInstance();
        List<String> input = List.of("10", String.valueOf(Integer.MAX_VALUE), "789");

        //when & then
        Assertions.assertThatThrownBy(() -> service.operation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("더할 수 있는 값 범위를 초과하였습니다.");

    }

    @Test
    @DisplayName("커스텀 구분자 추출 테스트 - 성공")
    void SuccessFindCustomRex() throws Exception {
        //given
        PlusCalculator service = (PlusCalculator) PlusCalculator.getInstance();
        String input = "//CustomRex";
        String expect = "[,:CustomRex]";

        //when
        String customRex = service.findCustomRex(input);

        //then
        Assertions.assertThat(customRex).isEqualTo(expect);

    }

    @Test
    @DisplayName("숫자 추출 테스트 - 성공")
    void SuccessSplitDigits() throws Exception {
        //given
        CalculatorService service = PlusCalculator.getInstance();
        String input = "//ab\\n123ab456,789";
        int expectSize = 3;
        List<String> expectList = List.of("123", "456", "789");

        //when
        List<String> digitList = service.splitDigits(input);

        //then
        Assertions.assertThat(digitList.size()).isEqualTo(expectSize);
        Assertions.assertThat(digitList).isEqualTo(expectList);
    }


}

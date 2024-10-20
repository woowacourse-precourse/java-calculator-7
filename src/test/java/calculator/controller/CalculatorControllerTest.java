package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.dto.DelimiterInputDto;
import calculator.service.CalculatorService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    private final CalculatorController calculatorController = new CalculatorController(new CalculatorService());

    @DisplayName("문자열 덧셈 계산기 통합 테스트 성공")
    @Test
    void calculateSum() {

        //given
        String inputString = "//$\\n1$4,3:2";
        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(inputString, new ArrayList<>(List.of(",", ":")));

        //when
        int result = calculatorController.calculateSum(delimiterInputDto);

        //then
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("문자열 덧셈 계산기 통합 테스트 실패 숫자가 양수가 아닐경우")
    @Test
    void calculateSumMinusException() {

        //given
        String inputString = "//$\\n1$4,3:-2";
        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(inputString, new ArrayList<>(List.of(",", ":")));

        //when - then
        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 덧셈 계산기 통합 테스트 실패 커스텀 문자가 1글자가 아닐 경우")
    @Test
    void calculateSumCustomDelimiterRangeException() {

        //given
        String overCustomRange = "//$#\\n1$#4,3:2";
        String emptyCustomRange = "//\\n1,2,3,4";

        DelimiterInputDto delimiterInputDto1 =
                new DelimiterInputDto(overCustomRange, new ArrayList<>(List.of(",", ":")));

        DelimiterInputDto delimiterInputDto2 =
                new DelimiterInputDto(emptyCustomRange, new ArrayList<>(List.of(",", ":")));

        //when - then
        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 덧셈 계산기 통합 테스트 실패 커스텀 문자에 숫자가 들어올 경우")
    @Test
    void calculateSumCustomIsNumberException() {

        //given
        String inputString = "//9\\n194,3:2";
        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(inputString, new ArrayList<>(List.of(",", ":")));

        //when - then
        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 덧셈 계산기 통합 테스트 실패 커스텀 문자에 부호가 들어올 경우")
    @Test
    void calculateSumCustomIsPlusMinusException() {

        //given
        String customMinus = "//-\\n1-4,3:2";
        String customPlus = "//+\\n1+4,3:2";
        DelimiterInputDto delimiterInputDto1 =
                new DelimiterInputDto(customMinus, new ArrayList<>(List.of(",", ":")));
        DelimiterInputDto delimiterInputDto2 =
                new DelimiterInputDto(customPlus, new ArrayList<>(List.of(",", ":")));

        //when - then
        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 덧셈 계산기 통합 테스트 실패 입력 숫자에 공백이 들어올경우")
    @Test
    void calculateSumBlankException() {

        //given
        String inputString = "//$\\n1$4,3: 2";
        DelimiterInputDto delimiterInputDto =
                new DelimiterInputDto(inputString, new ArrayList<>(List.of(",", ":")));

        //when - then
        assertThatThrownBy(() -> calculatorController.calculateSum(delimiterInputDto))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
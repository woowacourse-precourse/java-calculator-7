package calculator.util;

import calculator.dto.CalculatorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.util.ExceptionUtil.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionUtilTest {

    @Test
    @DisplayName("커스텀 구분 문자열 X 내용이 비어있는 경우")
    void checkNoStr() {
        //given
        String str = "";
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> checkParamsIsNotEmpty(str));
    }

    @Test
    @DisplayName("커스텀 구분자가 비어있는 경우")
    void checkNoCustomDelim() {
        //given
        String str = "//\n1?2?3";
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> checkParamsIsNotEmpty(str));
    }

    @Test
    @DisplayName("커스텀 구분 문자열 O 문자열이 비어있는 경우")
    void checkNoStrWhenCustomDelim() {
        //given
        String str = "//?\n";
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> checkParamsIsNotEmpty(str));
    }

    @Test
    @DisplayName("계산되는 다음 값이 0보다 작은 숫자인 경우")
    void nextTargetIsLowThanZero() {
        //given
        String str = "-1";
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> checkNextTargetIsLiteral(str));
    }

    @Test
    @DisplayName("계산되는 다음 값이 숫자가 아닌 경우")
    void nextTargetIsNotLiteral1() {
        //given
        String str = " ";
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> checkNextTargetIsLiteral(str));
    }

    @Test
    @DisplayName("계산되는 다음 값이 숫자가 아닌 경우")
    void nextTargetIsNotLiteral2() {
        //given
        String str = "?";
        //then
        assertThrows(IllegalArgumentException.class,
                //when
                () -> checkNextTargetIsLiteral(str));
    }

    @Test
    @DisplayName("계산되는 다음 값이 정상적인 경우")
    void nextTargetIsBiggerThanZero() {
        //given
        String str = "20";
        //when
        int num = checkNextTargetIsLiteral(str);
        //then
        assertThat(num).isEqualTo(20);
    }

    @Test
    @DisplayName("커스텀 구분자와 계산 대상의 개수를 확인")
    void checkNumOfDelimAndTarget1(){
        //given
        CalculatorDTO calculatorDTO = new CalculatorDTO("//?\\n1?2?");

        //when
        assertThrows(IllegalArgumentException.class,
                () -> checkStringHasRightNumOfTarget(calculatorDTO));
    }

    @Test
    @DisplayName("일반 구분자와 계산 대상의 개수를 확인")
    void checkNumOfDelimAndTarget2(){
        //given
        CalculatorDTO calculatorDTO = new CalculatorDTO(",2,3");

        //when
        assertThrows(IllegalArgumentException.class,
                () -> checkStringHasRightNumOfTarget(calculatorDTO));
    }
}
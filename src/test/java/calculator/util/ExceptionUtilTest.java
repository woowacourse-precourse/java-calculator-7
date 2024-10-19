package calculator.util;

import calculator.dto.CalculatorDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.util.ExceptionUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionUtilTest {

    @Test
    @DisplayName("커스텀 구분 문자열 X 내용이 비어있는 경우")
    void checkNoStr(){
        //given
        String str = "";
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                //when
                () -> checkParamsIsNotEmpty(str));
    }

    @Test
    @DisplayName("커스텀 구분자가 비어있는 경우")
    void checkNoCustomDelim(){
        //given
        String str = "//\n1?2?3";
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                //when
                () -> checkParamsIsNotEmpty(str));
    }

    @Test
    @DisplayName("커스텀 구분 문자열 O 문자열이 비어있는 경우")
    void checkNoStrWhenCustomDelim() {
        //given
        String str = "//?\n";
        //then
        Assertions.assertThrows(IllegalArgumentException.class,
                //when
                () -> checkParamsIsNotEmpty(str));
    }
}
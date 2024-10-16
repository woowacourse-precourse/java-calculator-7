package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import separator.CustomSeparatorFormat;
import separator.Separator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @DisplayName("시작문자가 숫자면 기본구분자를, 시작문자가 숫자가 아니면 커스텀구분자를 생성한다.")
    @Test
    void validateStartChar(){
    //given
        List<String> defaultseparator = List.of(",",":");
        Calculator calculator = new Calculator(defaultseparator);

        String inputData = "//@!\n2341@!2031@!22122";
        String inputData2 = "2341,2031,22122";
    //when
        Boolean result = calculator.validateStartChar(inputData);
        Boolean result2 = calculator.validateStartChar(inputData2);

        //then
        Assertions.assertThat(result).isFalse();
        Assertions.assertThat(result2).isTrue();


    }

    @DisplayName("커스텀 구분문자를 검증한다.")
    @Test
    void validateCustomSeparatorFormat(){
        //given
        List<String> defaultseparator = List.of(",",":");
        Calculator calculator = new Calculator(defaultseparator);

        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "//@!\n2341@!2031@!22122";
        //when
        boolean b = calculator.validateCustomSeparatorFormat(inputData, customSeparatorFormat.getPattern());

        //then
        Assertions.assertThat(b).isTrue();

    }
    @DisplayName("커스텀 구분문자가 //로 시작하지 않으면 예외를 출력한다.")
    @Test
    void validateCustomSeparatorFormat2(){
        //given
        List<String> defaultseparator = List.of(",",":");
        Calculator calculator = new Calculator(defaultseparator);

        CustomSeparatorFormat customSeparatorFormat = new CustomSeparatorFormat();
        String inputData = "#@!/n2341@!2031@!22122";
        //when


        //then
        Assertions.assertThatThrownBy(()->
                calculator.validateCustomSeparatorFormat(inputData,customSeparatorFormat.getPattern())).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                calculator.validateCustomSeparatorFormat(inputData,customSeparatorFormat.getPattern())).isInstanceOf(IllegalArgumentException.class).hasMessage("커스텀구분자 생성형식을 확인해주세요.");
    }



//    @DisplayName("input값에 따라 적절한 구분자객체를 생성한다.")
//    @Test
//    void generateSeparators(){
//    //given
//        List<String> defaultseparator = List.of(",",":");
//        Calculator calculator = new Calculator(defaultseparator);
//        String inputData = "//@!/n2341@!2031@!22122";
//    //when
//        Separator separator = calculator.generateSeparators(inputData);
//
//        //then
//        Assertions.assertThat(separator.getSeparator()).hasSize(1);
//        Assertions.assertThat(separator.getSeparator().get(0)).isEqualTo("@!");
//
//    }

}
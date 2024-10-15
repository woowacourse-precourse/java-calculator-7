package calculator.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceImplTest {

    private CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    @DisplayName("1,2:3 이 주어졌을 때, 3개로 나뉘어지는지 검증한다.")
    void given_string_then_split_3() {
        String inputString = "1,2:3";
        List<String> validNumber = calculatorService.findValidNumber(inputString);
        List<String> testNumber = List.of("1", "2", "3");
        assertThat(validNumber).containsAll(testNumber);
    }

    @DisplayName("커스텀 구분자와 쉼표, 콜론: 을 함께 사용할 경우의 값 테스트")
    @Test
    void custom_delimiter_with_comma_and_colon_test(){
        String inputString = "//;\\n1;2;3,4:5";
        List<String> validNumber = calculatorService.findValidNumber(inputString);
        List<String> testNumber = Arrays.asList("1","2","3","4","5");
        assertThat(validNumber).containsAll(testNumber);
    }

    @DisplayName("쉼표, 커스텀구분자, 콜론: 을 함께 사용할 경우의 값 테스트")
    @Test
    void comma_with_custom_delimiter_colon_test(){
        String inputString = "//;\\n1,2,3;4:5";
        List<String> validNumber = calculatorService.findValidNumber(inputString);
        List<String> testNumber = Arrays.asList("1","2","3","4","5");
        assertThat(validNumber).containsAll(testNumber);
    }

    @DisplayName("커스텀 구분자가 한 자리가 아닐 경우 테스트")
    @Test
    void custom_delimiter_is_not_one_digit(){
        String inputString = "//;;;;;;!!!!!\\n1;;;;;;!!!!!2;;;;;;!!!!!3;;;;;;!!!!!4";
        List<String> validNumber = calculatorService.findValidNumber(inputString);
        List<String> testNumber = Arrays.asList("1","2","3","4");
        assertThat(validNumber).containsAll(testNumber);
    }

}

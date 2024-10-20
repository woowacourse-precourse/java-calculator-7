package calculator.back.service.impl;

import static org.assertj.core.api.Assertions.*;

import calculator.back.dto.RequestDTO;
import calculator.back.exception.InvalidInputException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {

    private CalculatorServiceImpl calculatorServiceImpl;

    @BeforeEach
    void beforeEachTest() {
        this.calculatorServiceImpl = new CalculatorServiceImpl();
    }

    @Test
    @DisplayName("구분자들과 파싱할 문자열을 담은 객체를 계산")
    void 요청_DTO_계산_테스트1() {
        //given
        String inputWithDelimiters = "123|10c11*5.9;1";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        RequestDTO requestDTO = new RequestDTO(delimiters, inputWithDelimiters);
        Integer expectedInteger = 159;
        //when
        Integer calculatedInteger = calculatorServiceImpl.calculate(requestDTO);
        //then
        assertThat(expectedInteger).isEqualTo(calculatedInteger);
    }

    @Test
    @DisplayName("구분자들과 빈문자열을 담은 객체를 계산, 0 반환")
    void 빈_문자열_계산_테스트2() {
        //given
        String inputWithDelimiters = "";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        RequestDTO requestDTO = new RequestDTO(delimiters, inputWithDelimiters);
        Integer expectedInteger = 0;
        //when
        Integer calculatedInteger = calculatorServiceImpl.calculate(requestDTO);
        //then
        assertThat(expectedInteger).isEqualTo(calculatedInteger);
    }

    @Test
    @DisplayName("잘못된 문자열 형식을 담은 객체를 계산, 에외 반환")
    void 잘못된_문자열_예외_테스트() {
        //given
        String inputWithDelimiters = "1,2,3,";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        RequestDTO requestDTO = new RequestDTO(delimiters, inputWithDelimiters);
        //when
        //then
        assertThatThrownBy(() -> calculatorServiceImpl.calculate(requestDTO)).isInstanceOf(InvalidInputException.class);
    }
}
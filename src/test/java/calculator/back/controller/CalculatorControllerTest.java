package calculator.back.controller;

import static org.assertj.core.api.Assertions.*;

import calculator.back.dto.RequestDTO;
import calculator.back.dto.ResponseDTO;
import calculator.back.exception.InvalidInputException;
import calculator.back.service.CalculatorService;
import calculator.back.service.impl.CalculatorServiceImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {
    private CalculatorController calculatorController;
    private CalculatorService calculatorService;

    @BeforeEach
    void beforeEachTest() {
        this.calculatorController = new CalculatorController(new CalculatorServiceImpl());
    }

    @Test
    @DisplayName("RequestDTO에 대한 계산 결과인 ResponseDTO를 반환")
    void 컨트롤러_통합_테스트() {
        //given
        String inputWithDelimiters = "1|2c3|4*55";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        RequestDTO requestDTO = new RequestDTO(delimiters, inputWithDelimiters);
        ResponseDTO expectedResponseDTO = new ResponseDTO(String.valueOf(65));
        //when
        ResponseDTO calculatedResponseDTO = calculatorController.calculate(requestDTO);
        //then
        assertThat(expectedResponseDTO.output()).isEqualTo(calculatedResponseDTO.output());
    }

    @Test
    @DisplayName("음수를 담은 객체를 계산, 에외 반환")
    void 음수_문자열_예외_테스트() {
        //given
        String inputWithDelimiters = "1|2c-3|4*5";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        RequestDTO requestDTO = new RequestDTO(delimiters, inputWithDelimiters);
        //when
        //then
        assertThatThrownBy(() -> calculatorController.calculate(requestDTO)).isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("0을 담은 객체를 계산, 에외 반환")
    void 영_문자열_예외_테스트() {
        //given
        String inputWithDelimiters = "1|2c-3|4*0";
        List<Character> delimiters = List.of('c', '|', '*', '.', ';');
        RequestDTO requestDTO = new RequestDTO(delimiters, inputWithDelimiters);
        //when
        //then
        assertThatThrownBy(() -> calculatorController.calculate(requestDTO)).isInstanceOf(InvalidInputException.class);
    }

}
package calculator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.service.CalculatorService;
import calculator.viiew.CalculatorView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {


    private CalculatorController calculatorController;
    private CalculatorService calculatorService;
    private CalculatorView calculatorView;

    @BeforeEach
    void init() {
        calculatorService = new CalculatorService();
    }

    @DisplayName("기본 문자열 입력 시 계산")
    @Test
    void calculateDefault() {
        setupController("1,2:3", 6);
        calculatorController.calculate();
    }

    @DisplayName("빈값이 포함된 문자열일 경우 계산")
    @Test
    void calculateContainsEmpty() {
        setupController("1,,2", 3);
        calculatorController.calculate();
    }

    @DisplayName("빈 문자열일 경우 계산")
    @Test
    void calculateOnlyEmpty() {
        setupController("", 0);
        calculatorController.calculate();
    }

    @DisplayName("커스텀 구분자가 있는 문자열일 경우 계산")
    @Test
    void calculatorCustom() {
        setupController("//:\\n1:2:3", 6);
        calculatorController.calculate();
    }

    @DisplayName("음수 사용시 예외 발생")
    @Test
    void calculatorNegativeNumberException() {
        setupControllerWithException("-1,2,3");
    }

    @DisplayName("기본 구분자 중 잘못된 입력일 경우 예외 발생")
    @Test
    void calculatorDefaultException() {
        setupControllerWithException("1,2:3a");
    }

    @DisplayName("커스텀 구분자 중 잘못된 입력일 경우 예외 발생")
    @Test
    void calculatorCustomException() {
        setupControllerWithException("//:\\n1:2a:3");
    }

    private void setupController(String input, int expectedResult) {
        calculatorView = new CalculatorView() {
            @Override
            public String input() {
                return input;
            }

            @Override
            public void resultOutput(int result) {
                assertThat(result).isEqualTo(expectedResult);
            }
        };
        calculatorController = new CalculatorController(calculatorService, calculatorView);
    }

    private void setupControllerWithException(String input) {
        calculatorView = new CalculatorView() {
            @Override
            public String input() {
                return input;
            }
        };

        calculatorController = new CalculatorController(calculatorService, calculatorView);
        assertThatThrownBy(() -> calculatorController.calculate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 값이 입력되었습니다.");
    }

}
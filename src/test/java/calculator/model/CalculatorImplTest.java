package calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.validator.ValueValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorImplTest {

    AppConfig appConfig = new AppConfig();

    @Test
    @DisplayName("빈 입력값이 들어왔을 때 예외를 발생시키는지 테스트")
    void 빈_입력값_테스트() {

        //given
        Calculator calculator = appConfig.calculator();

        //when
        int resultForEmptyString = calculator.calculate("");
        int resultForNullInput = calculator.calculate(null);

        //then
        assertEquals(0, resultForEmptyString);
        assertEquals(0, resultForNullInput);
    }

    @Test
    @DisplayName("음수 입력값이 들어왔을 때 예외를 발생시키는지 테스트")
    void 음수_입력값_테스트() {

        //given
        Calculator calculator = appConfig.calculator();

        //when, then
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate("1,-2,3"));
    }

    @Test
    @DisplayName("정상적인 입력값을 받아 합을 계산하는지 테스트")
    void 정상_입력값_테스트() {
        //given
        Calculator calculator = appConfig.calculator();

        //when
        int result = calculator.calculate("1,2,3");

        //then
        assertEquals(6, result);
    }

    class AppConfig {

        public Calculator calculator() {
            return new CalculatorImpl(extractNumber());
        }

        private ExtractNumber extractNumber() {
            return new ExtractNumber(delimiterValidator(), valueValidator());
        }

        private Validator delimiterValidator() {
            return new DelimiterValidator();
        }

        private Validator valueValidator() {
            return new ValueValidator();
        }
    }
}
package calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.Calculator;
import calculator.model.CalculatorImpl;
import calculator.model.ExtractNumber;
import calculator.util.MessageSource;
import calculator.validator.DelimiterValidator;
import calculator.validator.Validator;
import calculator.validator.ValueValidate;
import calculator.view.CalculatorView;
import java.util.Locale;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    @Test
    @DisplayName("run 메서드가 정상적으로 동작하는지 테스트")
    void run_메서드_테스트() {

        //given
        AppConfig appConfig = new AppConfig(Locale.KOREA);

        TestCalculatorView testCalculatorView = new TestCalculatorView("1,2,3");
        CalculatorController calculatorController = appConfig.calculatorController(testCalculatorView);

        //when
        calculatorController.run();

        //then
        assertEquals("6", testCalculatorView.getResult());
    }

    class TestCalculatorView implements CalculatorView {

        private final String input;
        private String result;

        TestCalculatorView(String input) {
            this.input = input;
        }

        @Override
        public String getInput() {
            return input;
        }

        @Override
        public void showResult(int result) {
            this.result = String.valueOf(result);
        }

        public String getResult() {
            return result;
        }
    }

    class AppConfig {

        private final Locale locale;

        public AppConfig(Locale locale) {
            this.locale = locale;
        }

        public CalculatorController calculatorController(CalculatorView calculatorView) {
            return new CalculatorController(calculator(), calculatorView);
        }

        private Calculator calculator() {
            return new CalculatorImpl(extractNumber(), messageSource());
        }

        private ExtractNumber extractNumber() {
            return new ExtractNumber(delimiterValidator(), valueValidator(), messageSource());
        }

        private Validator delimiterValidator() {
            return new DelimiterValidator(messageSource());
        }

        private Validator valueValidator() {
            return new ValueValidate(messageSource());
        }

        public MessageSource messageSource() {
            return new MessageSource(locale);
        }

    }
}
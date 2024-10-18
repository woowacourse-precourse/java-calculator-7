package calculator.domain.calculator.service;

public interface StringCalculatorService {

    static StringCalculatorService getInstance() {
        return StringCalculatorServiceImpl.getInstance();
    }

    int calculate(String input);
}

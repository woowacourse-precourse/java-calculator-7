package calculator;

public interface CalculationManager {
    // 계산기 기능을 정의하는 인터페이스
    interface Calculator {
        int calculate(String input);
    }

    // 입력 검증 기능을 정의하는 인터페이스
    interface Validator {
        void validate(String input);
    }
}


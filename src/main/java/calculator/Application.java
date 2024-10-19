package calculator;

import calculator.CalculationManager.Calculator;
import calculator.CalculationManager.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final Validator inputValidator;
    private final Calculator stringAddCalculator;

    // 의존성 주입
    public Application(Validator inputValidator, Calculator stringAddCalculator) {
        this.inputValidator = inputValidator;
        this.stringAddCalculator = stringAddCalculator;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 앞뒤 공백 제거
        input = input.trim();

        // 사용자 입력값 검증
        inputValidator.validate(input);

        // 계산 수행
        int result = stringAddCalculator.calculate(input);
        System.out.println("결과 : " + result);
    }

    public static void main(String[] args) {
        // 객체를 생성하여 Application에 주입
        Validator validator = new InputValidator();
        Calculator calculator = new StringAddCalculator();
        Application app = new Application(validator, calculator);

        // 프로그램 실행
        app.run();
    }
}

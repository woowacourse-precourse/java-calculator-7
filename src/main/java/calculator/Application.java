package calculator;

import calculator.console.CalculatorConsole;
import calculator.domain.Adder;
import calculator.domain.DelimiterManager;
import calculator.domain.Separator;
import calculator.exception.ExceptionHandler;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 객체들 생성
        DelimiterManager delimiterManager = new DelimiterManager();
        Separator separator = new Separator(delimiterManager);
        Adder adder = new Adder();
        ExceptionHandler exceptionHandler = new ExceptionHandler(delimiterManager);

        // CalculatorConsole 객체를 생성하여 계산기를 실행
        CalculatorConsole calculatorConsole = new CalculatorConsole(separator, adder,
            exceptionHandler);

        // 계산기 실행
        calculatorConsole.run();
    }
}

package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.io.ConsoleInputHandler;
import calculator.controller.io.ConsoleOutputHandler;
import calculator.model.CalculatorModel;
import calculator.model.InputParser;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //CalculatorController 객체를 생성 및 필요한 핸들러와 모델을 주입
        CalculatorController calculatorController = new CalculatorController(new ConsoleInputHandler(),
                new ConsoleOutputHandler(), //콘솔 출력 핸들러
                new CalculatorModel(),      //계산 로직
                new InputParser());         //입력 파싱
        calculatorController.run();         //컨트롤러 실행
    }
}

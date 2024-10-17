package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.InputParser;
import calculator.view.View;

public class Application {

    // 기본 생성자
    public Application() {
    }

    // 프로그램의 메인 진입점
    public static void main(String[] args) {
        // 필요한 객체들을 생성
        Calculator calculator = new Calculator(); // 덧셈 계산을 담당하는 Calculator
        InputParser inputParser = new InputParser(); // 입력을 파싱하는 InputParser
        View view = new View(); // 사용자와의 인터페이스 담당 (입력 및 출력)
        // Controller를 생성하여 Model과 View를 연결
        CalculatorController controller = new CalculatorController(calculator, inputParser, view);
        // 프로그램 실행
        controller.run();
    }
}
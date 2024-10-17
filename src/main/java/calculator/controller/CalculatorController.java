package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.InputParser;
import calculator.view.View;

public class CalculatorController {

    // Calculator (덧셈 연산 담당), InputParser (입력 파싱 담당), View (입출력 담당) 객체
    private final Calculator calculator;
    private final InputParser inputParser;
    private final View view;

    // 생성자: Calculator, InputParser, View 객체를 주입받아 초기화
    public CalculatorController(Calculator calculator, InputParser inputParser, View view) {
        this.calculator = calculator;
        this.inputParser = inputParser;
        this.view = view;
    }

    // 프로그램의 메인 실행 로직
    public void run() {
        try {
            // View를 통해 사용자로부터 입력을 받음
            String input = this.view.getInput();

            // InputParser를 사용하여 입력을 파싱하고, 파싱된 숫자 배열을 얻음
            String[] parsedNumbers = this.inputParser.parse(input).getNumbers();

            // Calculator를 사용하여 숫자의 합계를 계산
            int result = this.calculator.add(parsedNumbers);

            // 결과를 View를 통해 출력
            this.view.printResult(result);
        } catch (IllegalArgumentException e) {
            // 입력이 잘못되었을 경우, 에러 메시지를 출력하고 예외를 다시 던짐
            this.view.printError(e.getMessage());
            throw e;
        }
    }
}
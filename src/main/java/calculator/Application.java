package calculator;


import calculator.service.CalculatorService;
import calculator.service.InputService;
import calculator.service.OutputService;

public class Application {

    public static void main(String[] args) {
        // TODO: 문자열 입력, 커스텀 구분자 추출 후 입력 문자열, 구분자 반환
        InputService inputService = new InputService();
        // TODO: 인자로 보내진 문자열과 구분자로 숫자 추출 후 더함. 더해진 값 반환
        CalculatorService calculatorService = new CalculatorService();
        // TODO: 반환된 결과값 출력
        OutputService outputService = new OutputService();
    }
}

package calculator;

import calculator.service.CalculateService;
import calculator.service.InputService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputService inputService = new InputService();
        CalculateService calculateService;

        // 기능 0 : 사용자가 덧셈할 문자열을 입력한다.
//        inputService.enterInput();

        // 기능 1 : 문자열 앞부분에 커스텀 구분자가 있는지 확인한다.
        // 기능 2 : 커스텀 구분자가 있을 때 값을 계산한다.
        if (inputService.isCustomDelimiter()) {
            String[] numbers = inputService.separateString();
            calculateService = new CalculateService(numbers);
            calculateService.calculate();

            System.out.println("결과 : " + calculateService.getSum());
        }
        // 기능 3 : 커스텀 구분자가 없을 때 값을 계산한다.
        else {
        }
    }
}

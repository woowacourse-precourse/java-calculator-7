package calculator;

import calculator.IO.InputService;

public class FrontController {
    public void run() {
        AppConfig appConfig = AppConfig.getInstance();

        InputService inputService = appConfig.getInputService();

        // 덧셈할 문자열 입력 받기
        inputService.readFormula();
        // 문자열 검사하기
        inputService.checkValidFormula();
    }
}
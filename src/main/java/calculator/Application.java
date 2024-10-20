package calculator;

import calculator.config.AppConfig;
import calculator.controller.Controller;
import calculator.view.InputHandler;
import calculator.view.OutputHandler;

public class Application {
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();

        InputHandler inputHandler = config.inputHandler();
        String input = inputHandler.getInput(); // 사용자 입력 받기

        Controller controller = config.controller(input); // Controller와 필요한 객체들 생성
        String answer = controller.run(input); // 계산 실행

        OutputHandler outputHandler = config.outputHandler();
        outputHandler.print(answer); // 결과 출력
    }
}

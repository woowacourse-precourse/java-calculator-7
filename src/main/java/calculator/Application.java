package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutView;

public class Application {
    private final InputView inputView = new InputView();
    private final OutView outView = new OutView();
    private final StringCalculator stringCalculator = new StringCalculator();

    public static void main(String[] args) {
        new Application().run();  // 애플리케이션 실행
    }

    private void run() {

        // 사용자 입력 받기
        String input = inputView.getStringFromUser();

        int result = stringCalculator.calculate(input);

        //결과 출력
        outView.printResult(result);

    }

}

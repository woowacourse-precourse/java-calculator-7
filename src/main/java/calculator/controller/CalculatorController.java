package calculator.controller;

import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void proceed() {
        String userInput = inputView.inputUserString();
        if (userInput.isEmpty()) {
            outputView.printResult(0);
            return;
        }
        int result = calculateString(DelimiterSeparator.detectCustomDelimiter(userInput), userInput);
        outputView.printResult(result);
    }

    public int calculateString(int index, String userInput) {
        boolean isPreviousValueNumeric = false;
        int sum = 0;
        for (int i = index; i < userInput.length(); i++) {
            if (isPreviousValueNumeric) {
                DelimiterSeparator.validateDelimiter(userInput.charAt(i));
                isPreviousValueNumeric = false;
                continue;
            }
            // 만약 테스트 실패나오면 while 문으로 여러자리 숫자 포함해서 더해주기..
            sum += extractNumber(String.valueOf(userInput.charAt(i)));
            isPreviousValueNumeric = true;
        }
        return sum;
    }

    public int extractNumber(String str) {
        if (!NumberChecker.isNumber(str)) {
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        return Integer.parseInt(str);
    }
}

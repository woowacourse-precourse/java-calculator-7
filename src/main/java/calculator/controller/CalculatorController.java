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
            /* 테스트 실패하면
            int[2] result = extractNumber(String.valueOf(userInput.charAt(i)),i);
            sum += result[0];
            i = result[1];
            isPreviousValueNumeric = true;
            변경 + 테스트 코드 만들기!
            * */
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

    /*
    public int extractNumber(String input,int idx){
        int[] sumAndIdx = new int[2];
        if(!NumberChecker.isNumber(input.charAt(idx))){
            throw new IllegalArgumentException("잘못된 형식입니다.");
        }
        String number = input.charAt(idx);
        while(true){
            idx++;
            if(!NumberChecker.isNumber(input.charAt(idx)) break;
            number += input.charAt(idx);
        }
        int[0] = Integer.parseInt(number);
        int[1] = idx;
        return sumAndIdx;
    }
    */
}

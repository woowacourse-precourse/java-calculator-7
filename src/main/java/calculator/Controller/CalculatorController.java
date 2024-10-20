package calculator.Controller;

import calculator.Utils.StringUtils;
import calculator.View.CalculatorView;

import java.io.Console;

public class CalculatorController {
    private CalculatorView view;

    public CalculatorController(CalculatorView view) {
        this.view = view;
    }

    public void run() {
        String input = view.getUserInput();

        validateInput(input);

        try {
            //TODO: 입력 받은 내용 더하기
        } catch (IllegalArgumentException e) {
            view.showError("잘못된 입력입니다. 다시 시도해주세요.");
        }
    }

    /**
     * 입력 문자열을 기본 구분자(쉼표, 콜론)로 분리하고, 각 요소가 자연수인지 확인합니다.
     * @param input 입력된 문자열
     * @throws IllegalArgumentException 입력 값이 null, 숫자가 아닌 경우, 또는 음수인 경우
     */
    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }

        // 기본 구분자로 문자열 분리
        String[] numbers = StringUtils.splitInput(input, "[,|:]");
        for (String number : numbers) {
            try {
                long parsedNumber = Long.parseLong(number);
                if (parsedNumber < 0) { // 음수인 경우 예외 발생
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
            }
        }
    }
}

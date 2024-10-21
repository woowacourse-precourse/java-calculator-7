package calculator.Controller;

import calculator.Model.Calculator;
import calculator.Utils.StringUtils;
import calculator.View.CalculatorView;

import java.io.Console;

public class CalculatorController {
    private CalculatorView view;
    private Calculator model;

    public CalculatorController(Calculator model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        String input = view.getUserInput();

        validateInput(input);

        try {
            int result = model.add(input);
            view.showResult(result);
        } catch (IllegalArgumentException e) {
            view.showError("잘못된 입력입니다. 다시 시도해주세요.");
        }
    }

    /**
     * 입력 문자열을 커스텀 구분자 또는 기본 구분자(쉼표, 콜론)로 분리하고, 각 요소가 자연수인지 확인합니다.
     * @param input 입력된 문자열
     * @throws IllegalArgumentException 입력 값이 null, 잘못된 구분자가 포함된 경우, 숫자가 아닌 경우, 또는 음수인 경우
     */
    private void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null입니다.");
        }

        String delimiter = "[,|:]"; // 기본 구분자 (쉼표, 콜론)
        String numbersPart = input;

        // 커스텀 구분자 확인 및 처리
        if (input.startsWith("//")) {
            delimiter = StringUtils.extractCustomDelimiter(input); // 커스텀 구분자 추출
            numbersPart = StringUtils.extractNumbersPart(input);   // 숫자 부분 추출

            // 커스텀 구분자 외의 문자가 있는지 확인
            if (StringUtils.containsInvalidDelimiter(numbersPart, delimiter)) {
                throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다.");
            }
        }

        // 구분자로 문자열을 분리하고 각 숫자가 유효한지 확인
        String[] numbers = StringUtils.splitInput(numbersPart, delimiter);
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

package calculator.view;

import calculator.validate.CalculatorValidate;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final CalculatorValidate calculatorValidate;

    public InputView(CalculatorValidate calculatorValidate) {
        this.calculatorValidate = calculatorValidate;
    }

    /**
     * 고정 메세지 출력
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 사용자로부터 문자열 입력 받음
     * 입력 받은 문자열에서 커스텀 구분자를 사용하는지 확인
     * 커스텀 구분자를 사용 시 기존 구분자에 커스텀 구분자 추가
     * 수정된 구분자로 문자열 분리
     */
    public int[] getUserInput() {
        String invalidateString = Console.readLine();
        if (calculatorValidate.isUsingBlank(invalidateString)) {
            return new int[1];
        }
        String separtors = ",:";
        if (calculatorValidate.isUsingCustomSeparator(invalidateString)) {
            separtors += invalidateString.charAt(2);
            invalidateString = invalidateString.substring(5);
        }
        String[] invalidateStringArray = invalidateString.split("[" + separtors + "]");

        return calculatorValidate.isIntegerParsable(invalidateStringArray);
    }
}


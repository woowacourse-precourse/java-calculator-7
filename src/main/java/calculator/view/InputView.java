package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readInputForSum() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputForSum = Console.readLine();

        validateInputForSum(inputForSum);

        return inputForSum;
    }

    private void validateInputForSum(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("문자열 입력해주세요.");
        }
    }
}

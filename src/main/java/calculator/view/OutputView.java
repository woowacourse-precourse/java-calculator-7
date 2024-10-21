package calculator.view;

import calculator.service.dto.SumDto;

public class OutputView {

    private static final String MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT = "결과 : ";

    public static void printMessage() {
        System.out.println(MESSAGE);
    }

    public static void printResult(SumDto sumDto) {
        System.out.println(RESULT + sumDto.value());
    }
}

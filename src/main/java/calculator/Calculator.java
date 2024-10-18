package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Calculator {
    private static final String INPUT_STRING_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT_MESSAGE = "결과 : ";

    Converter converter;

    public Calculator() {
        this.converter = new Converter("[,:]", "//", "\\n");
    }

    public void run() {
        String input = inputString();
        List<Integer> integers = converter.convertNumbersFromString(input);
        PositiveNumbers positiveNumbers = PositiveNumbers.from(integers);
        printResult(positiveNumbers.calculateSum());
    }

    private String inputString() {
        System.out.println(INPUT_STRING_MESSAGE);
        return Console.readLine();
    }


    private void printResult(int result) {
        System.out.println(OUTPUT_RESULT_MESSAGE + result);
    }

}

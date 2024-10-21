package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    private final StringSplitter stringSplitter;
    private final NumberConverter numberConverter;
    private final SumCalculator sumCalculator;

    private static InputReader instance;

    private InputReader(StringSplitter stringSplitter, NumberConverter numberConverter, SumCalculator sumCalculator) {
        this.stringSplitter = stringSplitter;
        this.numberConverter = numberConverter;
        this.sumCalculator = sumCalculator;
    }

    public static InputReader getInstance(StringSplitter stringSplitter, NumberConverter numberConverter, SumCalculator sumCalculator) {
        if (instance == null) {
            instance = new InputReader(stringSplitter, numberConverter, sumCalculator);
        }
        return instance;
    }

    // 전체 입력을 처리하는 메서드
    public int readAndProcess() {
        System.out.println("문자열을 입력하세요:");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] splitStrings = stringSplitter.split(input);
        int[] numberArray = numberConverter.convertToNumberArray(splitStrings);
        return sumCalculator.calculateSum(numberArray);
    }
}

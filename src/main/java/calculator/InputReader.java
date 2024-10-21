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

}

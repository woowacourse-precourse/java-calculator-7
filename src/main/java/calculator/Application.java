package calculator;

import java.util.List;

public class Application {

    private static final String guideMessage = "계산할 값을 입력하세요.";

    public static void main(String[] args) {

        Splitter splitter = new Splitter();

        Io.print(guideMessage);
        String input = Io.input();

        String target = splitter.splitCustomSeparators(input);
        List<String> tokens = splitter.split(target);
        List<Integer> numbers = Converter.convertStringToInteger(tokens);

        long result = Calculator.sum(numbers);

        Io.print(Long.toString(result));
    }
}

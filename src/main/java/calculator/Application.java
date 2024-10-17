package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.read();
        StringToNumberConverter stringToNumberConverter = new StringToNumberConverter();
        SummationCalculator summationCalculator = new SummationCalculator();
        int result = summationCalculator.sum(stringToNumberConverter.convert(List.of(input)));
        System.out.println(result);
    }
}

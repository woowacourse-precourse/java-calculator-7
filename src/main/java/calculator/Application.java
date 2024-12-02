package calculator;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.readInput();
        Validator validator = new Validator();
        StringType stringType = validator.getStringType(input);
        Splitor splitor = stringType.getSplitor();
        Converter converter = new Converter();
        List<Integer> numbers = converter.convert(splitor.split());
        Calculator calculator = new Calculator(numbers);
        Integer result = calculator.sum();
        System.out.printf("결과 : %d\n", result);
    }
}

package calculator.model;

public class Calculator {
    public static int calculate(String input) {
        InputProcessor processor = new InputProcessor(input);
        String[] splitInput = processor.splitInput();

        int result = 0;
        for (String target : splitInput) {
            if (target.isEmpty()) {
                continue;
            }
            processor.isNegative(Integer.parseInt(target));
            result += Integer.parseInt(target);
        }

        return result;
    }
}
package calculator;

import java.util.List;

public class Controller {
    Input input = new Input();
    Output output = new Output();
    SeparatorManager separatorManager = new SeparatorManager();
    StringHandler stringHandler = new StringHandler();
    Validator validator = new Validator();
    Adder adder = new Adder();

    public void start() {
        output.printStart();
        String userInput = input.readInput();
        validator.validateInput(userInput);

        if (validator.hasCustomSeparator(userInput)) {
            String separator = stringHandler.extractSeparator(userInput);
            validator.validateSeparator(separator);
            separatorManager.add(separator);
            String rawNumbers = stringHandler.removeCustom(userInput);
            List<String> numbers = stringHandler.getNumbers(
                    separatorManager.getSeparators(),
                    rawNumbers);
            adder.add(numbers);
            output.printResult(adder.getAnswer());
        }

        if (validator.isStartWithDigit(userInput)) {
            List<String> numbers =  stringHandler.getNumbers(
                    separatorManager.getSeparators(),
                    userInput
            );
            adder.add(numbers);
            output.printResult(adder.getAnswer());
        }
    }
}

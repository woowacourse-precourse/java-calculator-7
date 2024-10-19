package calculator;

public class MainController {
    private String inputValue;

    public void run() {
        inputValue = Input.readInput();

        Delimiter delimiter = new Delimiter(inputValue);
        inputValue = delimiter.separateCustomDelimiter();

        Validator validator = new Validator(inputValue);
        validator.validateInput();
//        inputValue = validator.getInput();
//        System.out.println("inputValue = " + inputValue);

        String[] stringNumbers = delimiter.splitInput();
        // TODO
//        System.out.println("splitInput");
//        for (String stringNumber : stringNumbers) {
//            System.out.print(stringNumber + "^");
//        }
//        System.out.println();

        Calculator calculator = new Calculator();
        calculator.addNumbers(stringNumbers);

        Output.printResult(calculator.getSum());
    }
}

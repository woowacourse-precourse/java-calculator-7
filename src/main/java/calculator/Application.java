package calculator;

public class Application {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        ConsoleWriter consoleWriter = new ConsoleWriter();
        Separator separator = new Separator();
        Calculator calculator = new Calculator();

        String input = consoleReader.readCalcLine();
        int[] nums = separator.separateInput(input);
        int result = calculator.calcSum(nums);
        consoleWriter.writeCalcResult(result);
    }
}

package calculator;

public class Application {
    public static void main(String[] args) {
        StringInputReader inputReader = new StringInputReader();
        StringValidator validator = new StringValidator();

        String input = inputReader.readStringInput();
        String result = validator.validateAndProcess(input);
        System.out.println(result);
    }
}

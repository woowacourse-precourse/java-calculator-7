package calculator;

public class Application {
    public static void main(String[] args) {
        InputString inputString = new InputString();
        StringCheck stringCheck = new StringCheck();

        String input = inputString.input();
        String separators = stringCheck.checkSeparator(input);
        System.out.println(input);
        System.out.println(separators);
    }
}
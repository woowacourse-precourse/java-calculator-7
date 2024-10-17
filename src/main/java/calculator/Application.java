package calculator;

public class Application {
    public static void main(String[] args) {
        InputString inputString = new InputString();
        StringCheck stringCheck = new StringCheck();
        SplitString splitString = new SplitString();

        String input = inputString.input();
        String separators = stringCheck.checkSeparator(input);
        String[] splitNum = splitString.splitString(input, separators);
        System.out.println(input);
        System.out.println(separators);
        for (String s : splitNum) {
            System.out.println(s);
        }
    }
}
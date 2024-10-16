package calculator;

public class Application {
    public static void main(String[] args) {
        InputString inputString = new InputString();
        String input = inputString.input();
        System.out.println(input);
    }
}
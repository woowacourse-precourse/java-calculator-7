package calculator;


public class Calculator {
    private String No_Space_Input;

    public Calculator(String input) {
        String No_Space_Input = input.replaceAll("\\s+", "");
        System.out.println(No_Space_Input);
    }
}
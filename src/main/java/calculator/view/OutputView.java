package calculator.view;


import static java.lang.StringTemplate.STR;

public class OutputView {

    public static void printResult(int value) {
        String result = STR."결과는: ${value}";
        System.out.println(result);
    }
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}

package calculator;

public class Printer {
    public static void printInputMessage() {
        System.out.println(Constants.PRINT_INPUT);
    }

    public static void printResultMessage(int res) {
        System.out.println(Constants.PRINT_RESULT + res);
    }
}
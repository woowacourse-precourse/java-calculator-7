package calculator.view;

public class Output {
    public static final String RESULT = "결과 : ";

    private Output() {
    }

    public static void end(int number) {
        System.out.println(RESULT + number);
    }
}

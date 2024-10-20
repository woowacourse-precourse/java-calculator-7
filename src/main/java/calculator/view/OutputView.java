package calculator.view;

public class OutputView {
    private static final String RESULT = "결과 : ";

    public static void printResult(double number){
        String formattedNumber = formatNumber(number);
        System.out.println(RESULT + formattedNumber);
    }


    private static String formatNumber(double number) {
        if (isInteger(number)) {
            return String.valueOf((int) number);
        } else {
            return String.valueOf(number);
        }
    }

    public static boolean isInteger(double value) {
        return value % 1 == 0;
    }
}

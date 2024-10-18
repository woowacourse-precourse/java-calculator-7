package calculator.view;

public class OutputString {
    public OutputString() {
    }

    public static void outputResult(int result) {
        String resultMessage = ViewMessage.RESULT.getMessage()+result;
        System.out.println(resultMessage);
    }
}

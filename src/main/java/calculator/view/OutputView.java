package calculator.view;

public class OutputView {

    private static final String outputMessage = "결과 : %d";

    public static void printOutputMessage(Integer answer) {
        System.out.println(outputMessage.formatted(answer));
    }
}

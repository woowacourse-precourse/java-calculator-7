package calculator.view;

import static calculator.view.ViewMessage.OUTPUT_MESSAGE;

public class OutputView {
    public static void printResult(int result) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(OUTPUT_MESSAGE).append(result).toString());
    }
}

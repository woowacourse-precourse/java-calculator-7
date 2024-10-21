package view;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private static final String NOTICE_OUTPUT_CONTEXT = "결과 : ";

    public static void printOutput(int sum){
        System.out.print(OutputView.NOTICE_OUTPUT_CONTEXT + sum);

    }
}

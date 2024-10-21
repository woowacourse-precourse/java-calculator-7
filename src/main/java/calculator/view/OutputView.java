package calculator.view;

import calculator.dto.OutputResponse;

public class OutputView {
    public static void output(OutputResponse response) {
        System.out.println("결과 : " + response.result());
    }
}

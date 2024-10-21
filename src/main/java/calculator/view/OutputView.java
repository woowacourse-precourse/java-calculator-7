package calculator.view;

import java.math.BigInteger;

public class OutputView {

    private static final String OUTPUT_FORMAT = "결과 : %d";

    public void printResult(BigInteger result) {
        System.out.println(String.format(OUTPUT_FORMAT, result));
    }
}

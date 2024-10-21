package calculator.view;

import java.math.BigDecimal;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "결과 : ";

    public static void getOutputMessage(BigDecimal result){
        System.out.println(OUTPUT_MESSAGE + result);
    }
}

package calculator.view;

import calculator.dto.CalculatorResultDTO;
import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

public class StringCalculatorView implements CalculatorView{

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE_FORMAT = "결과 : %s\n";

    @Override
    public String displayInput() {
        System.out.println(INPUT_MESSAGE);
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    public void displayOutput(String output) {
        CalculatorResultDTO<BigDecimal> result = new CalculatorResultDTO<>(new BigDecimal(output));
        System.out.printf(OUTPUT_MESSAGE_FORMAT, result.getTotal());
    }

    public void displayOutput(CalculatorResultDTO<BigDecimal> total) {
        System.out.printf("전체 " + OUTPUT_MESSAGE_FORMAT, total.getTotal());
    }
}

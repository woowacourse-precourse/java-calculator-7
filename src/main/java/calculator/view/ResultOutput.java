package calculator.view;

import java.math.BigDecimal;

public class ResultOutput {
    public enum OutputMessage{
        OUTPUT_PROMPT("결과 : ");

        final private String message;

        public String getMessage(){
            return message;
        }

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public void promptResultOutput(BigDecimal result){
        String output;
        if(result.stripTrailingZeros().scale() <= 0) output = result.toBigInteger().toString();
        else output = result.toString();
        System.out.println(ResultOutput.OutputMessage.OUTPUT_PROMPT.getMessage() + output);
    }
}

package calculator.view;

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

    public void promptResultOutput(String result){
        System.out.println(ResultOutput.OutputMessage.OUTPUT_PROMPT.getMessage() + result);
    }
}

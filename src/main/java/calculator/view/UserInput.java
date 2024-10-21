package calculator.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    public enum InputMessage{
        INPUT_PROMPT("덧셈할 문자열을 입력해 주세요.");

        final private String message;

        public String getMessage(){
            return message;
        }

        InputMessage(String message) {
            this.message = message;
        }
    }

    public String promptUserInput(){
        System.out.println(InputMessage.INPUT_PROMPT.getMessage());
        String inputMessage = readLine();
        return inputMessage;
    }
}

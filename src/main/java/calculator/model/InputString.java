package calculator.model;

import java.util.Arrays;
import java.util.List;

/**
 * 입력받은 문자열 저장을 위한 InputString
 */
public class InputString {
    private String userInput;
    private char customSeparator;
    private List<Integer> userOperand;
    /**
    * 커스텀 구분자를 구분하여 대체 후 input을 저장하기 위한 메소드
    *
    * @param userInput
     */
    public void setUserInput(String userInput) {
        if(userInput.contains("//") && userInput.contains("\\n")) {
            customSeparator = userInput.replaceAll("[//\n]", "").charAt(0);
            String regex = String.format("[,:%s]", customSeparator);
            this.userInput = userInput.substring(userInput.indexOf("n")+1).replaceAll(regex, " ");
        } else {
            this.userInput = userInput.replaceAll("[,:]", " ");
        }
    }
    public String getUserInput() {
        return userInput;
    }

    public void setUserOperand(List<Integer> userOperand) {
        this.userOperand = userOperand;
    }

    public List<Integer> getUserOperand() {
        return userOperand;
    }
}

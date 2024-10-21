package calculator.model;

import calculator.exception.ExceptionMessage;
import org.assertj.core.internal.ErrorMessages;

public class Model {
    public int addNumber(String inputString) {
        if (inputString.isEmpty()) {
            return 0;
        }
        String[] input;
        if (inputString.startsWith("//")) {
            int index = inputString.indexOf("\\n");
            if (index == -1) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_VALUE.getMessage());
            }
            String numberSplitString = inputString.substring(2, index);
            inputString = inputString.substring(index + 2);
            input = inputString.split(numberSplitString);

        }
        else {
            input = inputString.split(",|:");
        }

        int answer = 0;

        for (int i = 0; i < input.length; i++) {
            int number = Integer.parseInt(input[i]);
            if (number < 0) {
                throw new IllegalArgumentException("음수입니다");
            }
            answer += number;
        }
        return answer;
    }
}

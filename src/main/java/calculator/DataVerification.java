package calculator;

import java.util.List;

public class DataVerification {
    public void checkIsInputEmpty(String userInput) {
        if (userInput.isEmpty()) {
            System.out.println("결과 : " + 0);
        }
    }

    public void checkIsPositiveNumber(List<String> splitInput) {
        for (String number : splitInput) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkHasNumberFormat(List<String> splitInput) {
        for (String number : splitInput) {
            if (Character.isDigit(Integer.parseInt(number))) {
                throw new IllegalArgumentException();
            }
        }
    }
}

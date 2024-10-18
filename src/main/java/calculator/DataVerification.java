package calculator;

public class DataVerification {
    public void checkIsInputEmpty(String userInput) {
        if (userInput.isEmpty()) {
            System.out.println("결과 : " + 0);
        }
    }

    public void checkIsPositiveNumber(SplitStringWithSeparator splitStringWithSeparator) {
        for (String number : splitStringWithSeparator.processedInput) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void checkHasNumberFormat(SplitStringWithSeparator splitStringWithSeparator) {
        for (String number : splitStringWithSeparator.processedInput) {
            if (Character.isDigit(Integer.parseInt(number))) {
                throw new IllegalArgumentException();
            }
        }
    }
}

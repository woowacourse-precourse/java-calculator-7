package calculator.model;

public class Validation {
   public void validateInputNumber(String[] splitNumber) {
        for (String number : splitNumber) {
            validateSingleNumber(number.trim());
        }
    }

   public void validateSingleNumber(String number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private boolean isValidNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package calculator;

public class StringValidator {
    public void validateNegativeNumber(String[] splitedString) {
        for (String numberStr : splitedString) {
            if (Integer.parseInt(numberStr.trim()) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
    public void validateString(String[] input){
        for (String str : input) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }
}

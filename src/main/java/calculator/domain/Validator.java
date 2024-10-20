package calculator.domain;

public class Validator {
    public int[] validateAndConvert(String[] numbers) {
        int[] numbersArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersArray[i] = Integer.parseInt(numbers[i]);
            if (numbersArray[i] < 0) {
                throw new IllegalArgumentException(numbersArray[i] + "는 음수 값입니다.");
            }
        }
        return numbersArray;
    }
}

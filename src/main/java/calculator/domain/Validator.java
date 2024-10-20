package calculator.domain;

public class Validator {
    public int[] validateAndConvert(String[] numbers) {
        if(numbers.length == 0) {
            throw new IllegalArgumentException("입력된 숫자가 존재하지 않습니다.");
        }

        int[] numbersArray = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            try {
                numbersArray[i] = Integer.parseInt(numbers[i]);

                if (numbersArray[i] < 0) {
                    throw new IllegalArgumentException(numbersArray[i] + "는 음수 값입니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(numbers[i]+ "는 유효한 숫자가 아닙니다.");
            }
        }
        return numbersArray;
    }
}

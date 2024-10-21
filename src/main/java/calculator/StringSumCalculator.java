package calculator;

public class StringSumCalculator {
    public int sumInString(String input) {
        // 숫자 추출 및 합산 로직을 수행
        // 숫자와 부호를 추출하기 위한 StringBuilder
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        StringBuilder currentNumber = new StringBuilder();
        int sum = 0;

        // 문자열 순회
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 음수 검사
            exceptionHandler.checkForNegativeNumbers(c, i, input);

            sum = numFindInString(c, sum, currentNumber);
        }

        sum = findTheTotal(sum, currentNumber);

        return sum;
    }

    public int numFindInString(char c, int sum, StringBuilder currentNumber) {

        if (Character.isDigit(c)) {
            currentNumber.append(c);
        } else {
            sum = findTheTotal(sum, currentNumber);
        }

        return sum;
    }

    public int findTheTotal(int sum, StringBuilder currentNumber) {
        if (currentNumber.length() > 0) {
            sum += Integer.parseInt(currentNumber.toString());
            currentNumber.setLength(0);  // StringBuilder 초기화
        }

        return sum;
    }
}

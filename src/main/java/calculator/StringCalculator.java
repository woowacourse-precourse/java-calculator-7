package calculator;

/**
 * StringCalculator 클래스는 주어진 문자열 입력에서 숫자를 더하는 기능을 수행합니다.
 */
public class StringCalculator {
    /**
     * 입력된 문자열에서 커스텀 구분자를 지원하며, 숫자가 아닌 값이 포함된 경우
     * IllegalArgumentException을 던집니다.
     *
     * @param input 커스텀 구분자와 숫자 문자열
     * @return 숫자의 합
     * @throws IllegalArgumentException 유효하지 않은 입력이 있을 경우 발생
     */
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,|:]";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            try {
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력: " + number);
            }
        }
        return sum;

    }
}

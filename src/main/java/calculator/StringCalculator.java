package calculator;

/**
 * StringCalculator 클래스는 주어진 문자열 입력에서 숫자를 더하는 기능을 수행합니다.
 */
public class StringCalculator {
    /**
     * 입력된 문자열에서 커스텀 구분자를 지원하여 숫자를 더합니다.
     * 커스텀 구분자는 문자열의 시작 부분에 "//"와 "\n" 사이에 위치합니다.
     *
     * @param input 커스텀 구분자를 포함한 숫자 문자열
     * @return 숫자의 합
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
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}

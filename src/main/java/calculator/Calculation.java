package calculator;

import java.util.Arrays;

public class Calculation {
    /**
     * 구분된 문자열 배열에서 숫자를 제외한 모든 문자 필터링
     */
    public String[] filterNumbers(String input) {
        Parser parser = new Parser();

        String[] parseredString = parser.split(input);

        //숫자가 아닌 문자들은 공백으로 변환
        return Arrays.stream(parseredString)
                .map(number -> number.replaceAll("[^0-9-]", ""))
                .filter(number -> !number.isEmpty() && !number.equals("-"))
                .toArray(String[]::new);
    }

    /**
     * 필터링된 문자열 배열에서 숫자로 변환 후 합 연산
     */
    public int sumNumbers(String[] exactNumbers) {
        int result = 0;

        for (String exactNumber : exactNumbers) {
            int beforeNumber = Integer.parseInt(exactNumber);

            if (beforeNumber < 0) {
                throw new IllegalArgumentException("음수는 허락되지 않습니다");
            }

            result += beforeNumber;
        }

        return result;
    }
}

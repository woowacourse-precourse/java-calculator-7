package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {


    /**
     * caculate 메소드 입력값의 유효성을 검증하고 구분자를 통해 문자열에서 숫자를 추출한다.
     *
     * @param input
     * @return
     */
    public int caculate(String input) {
        if (input == null || input.isEmpty()) { //입력값이 null 혹은 비어있다면
            return 0;   // 0을 반환한다.
        }

        String delimiter = ",|:"; //기본 구분자
        //커스텀 구분자
        if (input.startsWith("//") && input.contains("\n")) {
            Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(input); //와 \n 사이에 있는 구분자로 입력 문자열을 나눈다.
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                input = matcher.group(2);
            }
        }

        String[] numbers = input.split(delimiter); //입력값을 구분자로 나누어 String형 배열에 저장
        return sum(numbers);
    }


    private int sum(String[] numbers) {
        int total = 0;
        for (String number : numbers) {
            number = number.trim(); //양쪽 공백제거
            try {
                int num = Integer.parseInt(number);
                if (num < 0) { //숫자가 음수라면
                    throw new IllegalArgumentException();
                }
                total += num;
            } catch (NumberFormatException nfe) { //숫자가 아닌 문자열을 정수형으로 바꾸면 예외가 발생한다.
                throw new IllegalArgumentException();
            }
        }

        return total;
    }
}

package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

    }

    /**
     * 정규식으로 //와 \n 사이의 구분자를 추출하여 모든 구분자를 반환한다.
     *
     * @param input 구분자를 추출할 문자열
     * @return |로 구분한 기본 구분자와 커스텀 구분자
     * @throws IllegalArgumentException 입력이 //로 시작하였지만 구분자를 찾지 못한 경우
     */
    private static String getDelimiter(String input) throws IllegalArgumentException {
        String delimiters = ",|:";

        // 커스텀 구분자가 없는 경우
        if (!input.startsWith("//")) {
            return delimiters;
        }

        Pattern pattern = Pattern.compile("//(.)\\\\n");
        Matcher matcher = pattern.matcher(input);

        // //로 시작하였지만 구분자를 찾지 못함
        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
        }

        String customDelimiter = matcher.group(1);

        // '|'가 구분자로 들어온 경우 이스케이프 처리
        if (customDelimiter.equals("|")) {
            customDelimiter = "\\|";
        }

        delimiters = delimiters + "|" + customDelimiter;

        return delimiters;
    }

    /**
     * 주어진 입력을 구분자로 구분하고 정수로 변환하여 반환함
     * @param input 숫자로 변환할 문자열
     * @param delimiter 여러개의 구분자
     * @return 구분된 문자를 정수 List로 변환하여 반환함
     * @throws NumberFormatException 정수로 변환할 수 없는 값이 포함된 경우
     */
    private static List<Integer> getNumbers(String input, String delimiter) throws NumberFormatException{
        // 숫자 부분을 분리함
        String numberPart = input;
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            numberPart = input.substring(delimiterEnd + 2);
        }

        List<Integer> numbers = new ArrayList<>();
        if (numberPart.isEmpty()) {
            return numbers;
        }
        // 숫자부분을 구분하여 정수로 변환함
        String[] numberStrings = numberPart.split(delimiter);

        for (String numberString : numberStrings) {
            System.out.println(numberString);
            Integer number = Integer.parseInt(numberString);
            numbers.add(number);
        }

        return numbers;
    }

}

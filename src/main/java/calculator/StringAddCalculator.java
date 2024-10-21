package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public int calculate(String input) {
        // 입력 값이 없을 경우 0 리턴
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiters = ",|:";
        String numbers = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            // 커스텀 구분자 정규식 패턴
            // 커스텀 구분자는 //으로 시작해야하고
            // 숫자는 이외의 문자가 커스텀구분자로 들어가야 함 (캡처1)
            // 이후에 \n 이 있어야 하고
            // 이후의 문자열 (캡처2)
            Pattern customDelimiterPattern = Pattern.compile("^//([^0-9])\\\\n(.*)");
            Matcher matcher = customDelimiterPattern.matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("커스텀 구분자를 올바르게 지정해주세요.");
            }
            delimiters += "|" + matcher.group(1);
            numbers = matcher.group(2);
        }

        // 구분자를 기준으로 숫자 분리
        String[] result = numbers.split(delimiters);

        // 숫자 체크 및 형변환 그리고 합산 후 리턴
        int sum = 0;
        for (String token : result) {
            int number = validateAndParseInt(token);
            sum += number;
        }
        return sum;
    }

    //숫자 체크 및 변환 로직
    private int validateAndParseInt(String number) {
        // 입력 값이 없을 경우 0 리턴
        if (number == null || number.isEmpty()) {
            return 0;
        }

        int num;
        try {
            //형 변환
            num = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 숫자에 숫자가 아닌 값이 포함되어 있습니다.");
        }
        if (num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }

}

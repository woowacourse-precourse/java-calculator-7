package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationService {

    public static int sumStringNum(String stringNum) {
        String delimiter = ",|:";
        int sum = 0;

        // 커스텀 구분자인 경우 실행
        if (stringNum.contains("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(stringNum);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 설정
                stringNum = matcher.group(2); // 실제 숫자 부분 추출
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
        String[] values = stringNum.split(delimiter);

        for (String value : values) {
            int number = parsePositiveInt(value);
            sum += number;
        }

        return sum;
    }

    // 양수만 처리하고, 잘못된 값에 대해 예외 발생
    private static int parsePositiveInt(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + value);
        }
    }
}




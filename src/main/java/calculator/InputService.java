package calculator;

import calculator.model.InputData;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputService {
    static String DEFAULT_DELIMITER = ",|:";

    public static InputData readLine() {
        System.out.println("숫자가 포함된 문자열을 입력하세요: ");
        String customDelimiter = "";

        try {
            String input = Console.readLine();
            if (input.startsWith("//")) {
                int newlineIndex = input.indexOf("\\n");

                if (newlineIndex == -1) {
                    throw new IllegalArgumentException();
                }
                return parseCustomDelimiter(input);

            }

            return new InputData(input, customDelimiter.isEmpty() ? DEFAULT_DELIMITER : customDelimiter);

        } catch (Exception e) {
            throw new IllegalArgumentException(e);

        }

    }

    private static InputData parseCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\\\\n(.*)").matcher(input);
            if (matcher.find()) {
                String delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 설정
                String body = matcher.group(2); // 실제 숫자 부분 추출

                return new InputData(body, delimiter);
            } else {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
        }
        throw new IllegalArgumentException("custom delimiter 형식이 아닙니다. ");

    }

}

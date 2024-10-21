package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    static final String regex = "//(.*?)\\\\n";
    static Set<String> separators = new HashSet<>(Arrays.asList(",", ":"));

    public String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void run() {
        String inputValue = input();
        boolean hasCustom = extractCustomSeparators(inputValue);
        if (hasCustom) {
            inputValue = extractNumbersPart(inputValue);
        }
        logger.info("추출된 구분자: " + separators);
        logger.info("숫자 부분: " + inputValue);
        String[] numbers = splitNumbers(inputValue);
        validate(numbers);
        int result = calculateSum(numbers);
        System.out.println("결과 : " + result);
    }

    static boolean extractCustomSeparators(String input) {
        boolean flag = false;
        if (input == null) {
            System.out.println("빈문자열");
            return flag;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            flag = true;
            updateSeperator(matcher.group(1).trim());
        }
        return flag;
    }

    static void updateSeperator(String str) {
        separators.add(str);
    }

    static String extractNumbersPart(String input) {
        // 커스텀 구분자를 제거 한 문자열 출력
        return input.replaceAll(regex, "").trim();
    }

    static String[] splitNumbers(String numbersPart) {
        if (numbersPart == null) {
            return new String[0]; // 빈 배열을 반환
        }
        return numbersPart.split(String.join("|", separators));
    }

    static void validate(String[] numbers) {
        //양의 정수 정규식
        String numberRegex = "^[1-9][0-9]*$";
        for (String data : numbers) {
            if (data == null || data.trim().isEmpty()) {
                continue;
            }
            //해당 문자가 숫자형인지
            if (!data.matches(numberRegex)) {
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
            }
        }
    }

    static int calculateSum(String[] numbers) {
        // 구분자로 나누고 각 숫자의 합을 계산합니다.
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number);
            }
        }
        return sum;
    }
}

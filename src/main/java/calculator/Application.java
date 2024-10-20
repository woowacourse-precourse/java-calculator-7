package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final String DEFAULT_SEPERATOR_REGEX = ",|:";
    private static final String CUSTOM_SEPERATOR_REGEX = "//(.)\\\\n(.*)";

    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String expression = getExpression();

        validateExpression(expression);

        String[] numList = parseNumbersFromExpression(expression);
        System.out.println("결과 : " + getResult(numList));
    }

    private static void validateExpression(String expression) {

        if (expression.isEmpty() || expression == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        if (expression.startsWith("//")) {
            if (!expression.contains("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
            }
        }
    }

    private static int getResult(String[] list) {

        int result = 0;
        for (String num : list) {
            try {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                result += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자도 구분자도 아닌 값이 포함되어 있습니다.");
            }
        }
        return result;
    }

    private static String[] parseNumbersFromExpression(String expression) {

        Matcher matcher = Pattern.compile(CUSTOM_SEPERATOR_REGEX).matcher(expression);
        if (matcher.find()) {
            String customSeperator = matcher.group(1);
            String numberExpression = matcher.group(2);
            return numberExpression.split(customSeperator);
        }
        return expression.split(DEFAULT_SEPERATOR_REGEX);
    }

    private static String getExpression() {

        // 사용자 입력 후 자원 해제 및 반환
        String input = Console.readLine();
        Console.close();
        return input;
    }

}

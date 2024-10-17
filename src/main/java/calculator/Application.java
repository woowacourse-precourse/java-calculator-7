package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        if (input.isEmpty()) { // 빈 문자열 입력 시 0 출력
            System.out.println("결과 : 0");
            return;
        }

        String delimiter = ",|:";
        String values = "";

        Pattern customDelimiterPattern = Pattern.compile("//(.)\\\\n(.*)");
        if (Pattern.matches("//(.)\\\\n(.*)", input)) { // 입력값이랑 정규표현식이랑 일치하는지 확인
            Matcher matcher = customDelimiterPattern.matcher(input); //
            if (matcher.matches()) { // 입력값이 해당 정규표현식과 완벽하게 일치하는지 확인
                delimiter += "|" + matcher.group(1);
                values += matcher.group(2);
            }
        }

        String[] splitValues = values.split(delimiter);

        int sum = 0;
        for (String value : splitValues) {
            if (!isPositiveInteger(value)) {
                throw new IllegalArgumentException();
            }
            sum += Integer.parseInt(value);
        }

        System.out.println("결과 : " + sum);
    }

    // 문자열을 양수로 변환할 수 있는지 체크
    private static boolean isPositiveInteger(String s) {
        try {
            // parseInt 안되면 NumberFormatException 발생
            int number = Integer.parseInt(s);
            return number > 0;  // 양수만 통과
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

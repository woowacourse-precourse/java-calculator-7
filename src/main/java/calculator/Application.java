package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        int sum = calculateStringSum(input);
        System.out.printf("결과 : %d\n", sum);
    }

    private static int calculateStringSum(String input) {
        String[] nums = getNums(input);
        return getSum(nums);
    }

    private static int getSum(String[] nums) {
        try {
            int answer = 0;
            for (String str : nums) {
                int i = Integer.parseInt(str);
                if (i < 0) {
                    throw new IllegalArgumentException();
                }
                answer += i;
            }
            return answer;

        } catch (Exception e) {
            System.out.println("잘못된 값을 입력하셨습니다");
            throw new IllegalArgumentException();
        }
    }

    private static String[] getNums(String input) {
        String delimiter;
        if (input.contains("\\n")) {
            delimiter = getDelimiter(input.substring(0, input.indexOf("\\n") + 2));
            input = input.substring(input.indexOf("\\n") + 2);
        } else {
            delimiter = getDelimiter("");
        }
        input = input.isEmpty() ? "0" : input;
        return input.split(delimiter);
    }


    public static String getDelimiter(String input) {

        List<String> delimiters = new ArrayList<>(List.of(",", ":"));
        Pattern pattern = Pattern.compile("//([^.$|()\\[\\]\\\\{^?*+]+)\\\\n");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String group = matcher.group(1);
            delimiters.addAll(List.of(group.split("")));
        }
        return String.join("|", delimiters);

    }
}

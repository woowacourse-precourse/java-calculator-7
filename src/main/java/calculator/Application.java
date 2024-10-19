package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        // 구분자 설정
        List<Character> delimiters = new ArrayList<>();
        delimiters.add(':');
        delimiters.add(',');

        // 커스텀 문자열 추가
        char customDelimiter = checkDelimiter(input);
        if (customDelimiter != '\0') {
            delimiters.add(customDelimiter);
            input = input.substring(5);
        }

        // 숫자로 분리
        List<String> numStrings = splitByDelimiter(input, delimiters);
        List<Integer> nums = changeToInteger(numStrings);

        // 계산
        Integer answer = calculate(nums);

        System.out.println("결과 : " + answer);
    }

    private static char checkDelimiter(String input) {
        if (Pattern.matches("^//.*\\\\n.*$", input)) {
            return input.charAt(2);
        }
        return '\0';
    }

    private static List<String> splitByDelimiter(String input, List<Character> delimiter) {
        List<String> response = new ArrayList<>();
        String curNum = "";

        int i;
        for (i = 0; i < input.length(); i++) {
            if (delimiter.contains(input.charAt(i))) {
                response.add(curNum);
                curNum = "";
            } else if (input.charAt(i) >= '1' && input.charAt(i) <= '9') {
                curNum += input.charAt(i);
            } else if (input.charAt(i) == '0' && !curNum.isEmpty()) {
                curNum += '0';
            } else {
                // 숫자의 가장 앞에 0이 등장하는 경우
                // 입력으로 구분자나 숫자가 아닌 문자가 들어온 경우 예외 처리
                throw new IllegalArgumentException();
            }
        }
        if (!curNum.isEmpty()) {
            response.add(curNum);
        } else if (i != 0) {
            // 가장 마지막 입력이 양수가 아닌 경우 예외 처리
            throw new IllegalArgumentException();
        }

        return response;
    }

    private static List<Integer> changeToInteger(List<String> numStrings) {
        List<Integer> nums = new ArrayList<>();

        for (String numString : numStrings) {
            Integer tempNum = Integer.parseInt(numString);
            nums.add(tempNum);
        }

        return nums;
    }

    private static Integer calculate(List<Integer> nums) {
        Integer sum = 0;

        for (Integer num : nums) {
            sum += num;
        }

        return sum;
    }
}

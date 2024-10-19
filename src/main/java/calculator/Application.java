package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        // 구분자 설정
        List<Character> delimiters = new ArrayList<>();
        delimiters.add(':');
        delimiters.add(',');

        // 숫자로 분리
        List<String> numStrings = splitByDelimiter(input, delimiters);
        List<Integer> nums = changeToInteger(numStrings);

        // 계산
        Integer answer = calculate(nums);

        System.out.println("결과 : " + answer);
    }

    private static List<String> splitByDelimiter(String input, List<Character> delimiter) {
        List<String> response = new ArrayList<>();
        String curNum = "";

        for (int i = 0; i < input.length(); i++) {
            if (delimiter.contains(input.charAt(i))) {
                response.add(curNum);
                curNum = "";
            } else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                curNum += input.charAt(i);
            } else {
                // 예외 처리 필요
            }
        }
        if (curNum != "") {
            response.add(curNum);
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

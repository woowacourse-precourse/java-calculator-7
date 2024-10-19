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

        // 실수값인지 확인
        Boolean isDecimal = isDecimal(numStrings);
        if (isDecimal) {
            // 문자열 list 수로 변환
            List<Double> nums = changeToDouble(numStrings);
            // 계산
            Double answer = calculateDecimal(nums);
            System.out.println("결과 : " + answer);

        } else {
            // 문자열 list 수로 변환
            List<Integer> nums = changeToInteger(numStrings);
            // 계산
            Long answer = calculateInteger(nums);
            System.out.println("결과 : " + answer);
        }
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
                // 숫자 마지막에 .이 오는 경우에 대한 예외 처리
                if (curNum.length() != 0 && curNum.charAt(curNum.length() - 1) == '.') {
                    throw new IllegalArgumentException();
                }
                response.add(curNum);
                curNum = "";
            } else if (input.charAt(i) >= '1' && input.charAt(i) <= '9') {
                curNum += input.charAt(i);
            } else if (input.charAt(i) == '0' && !curNum.isEmpty()) {
                curNum += '0';
            } else if (input.charAt(i) == '.' && !curNum.contains(".") && !curNum.isEmpty()) {
                curNum += '.';
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

    private static Boolean isDecimal(List<String> numStrings) {
        for (String numString : numStrings) {
            if (numString.contains(".")) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer> changeToInteger(List<String> numStrings) {
        List<Integer> nums = new ArrayList<>();

        try {
            for (String numString : numStrings) {
                Integer tempNum = Integer.parseInt(numString);
                nums.add(tempNum);
            }
        } catch (NumberFormatException e) {
            // parseInt 함수에서 int 범위를 벗어난 경우에 대한 예외 처리
            throw new IllegalArgumentException();
        }
        return nums;
    }

    private static List<Double> changeToDouble(List<String> numStrings) {
        List<Double> nums = new ArrayList<>();

        for (String numString : numStrings) {
            Double tempNum = Double.parseDouble(numString);
            nums.add(tempNum);
        }
        return nums;
    }

    private static Long calculateInteger(List<Integer> nums) {
        Long sum = 0L;

        try {
            for (Integer num : nums) {
                sum = Math.addExact(sum, num);
            }
        } catch (ArithmeticException e) {
            // 수들의 합이 long 범위를 넘어가는 경우에 대한 오류처리
            throw new IllegalArgumentException();
        }

        return sum;
    }

    private static Double calculateDecimal(List<Double> nums) {
        Double sum = 0.0;
        for (Double num : nums) {
            sum += num;
        }
        return sum;
    }
}

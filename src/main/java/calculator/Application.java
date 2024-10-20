package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        List<String> sepList = separateInput(input);

        String delimiter = sepList.get(0);
        String str = sepList.get(1);

        // 문자열파트가 공백이라면 0 출력
        if (str.isEmpty()){
            System.out.println("결과 : " + 0);
        } else {
            int sum = calculate(splitByDelimiter(delimiter, str));
            System.out.println("결과 : " + sum);
        }
    }

    // 입력을 구분자파트와 문자열파트로 분리하는 메서드
    public static List<String> separateInput(String input){
        int start = input.indexOf("//");
        int end = input.indexOf("\\n");

        // 구분자파트가 없는 경우
        if (start == -1 && end == -1){
            return Arrays.asList("", input);
        }
        // 구분자 파트가 잘 들어온 경우
        else if (start == 0 && end == 3) {
            String delPart = String.valueOf(input.charAt(2));
            String strPart = input.substring(end + 2);

            return Arrays.asList(delPart, strPart);
        }

        throw new IllegalArgumentException("올바른 입력값을 넣어주세요.");

    }

    // 문자열을 구분자로 구분해주는 메서드
    private static List<Integer> splitByDelimiter(String delimiter, String str) {
        String[] splitedStringList = str.split("[" + Pattern.quote(delimiter) + ",:]");
        return convertToOperand(splitedStringList);
    }

    // 합을 구하는 메서드
    public static int calculate(List<Integer> operands){
        int sum = 0;
        for (Integer operand : operands) {
            sum+=operand;
        }

        return sum;
    }

    // 피연산자로 변환 하는 메서드
    private static List<Integer> convertToOperand(String[] operands){
        List<Integer> numbers = convertToDigit(operands);
        validatePositive(numbers);

        return numbers;
    }

    // 숫자로 변환하는 메서드
    private static List<Integer> convertToDigit(String[] operands){
        List<Integer> numbers = new ArrayList<>();

        for (String operand : operands) {
            try {
                numbers.add(Integer.valueOf(operand));
            } catch (NumberFormatException e){
                throw new IllegalArgumentException("피연산자는 숫자만 가능합니다.");
            }
        }
        return numbers;
    }

    // 양수 검증 메서드
    private static void validatePositive(List<Integer> numbers){
        for (Integer number : numbers) {
            if (number <= 0 ){
                throw  new IllegalArgumentException("양수만 가능합니다.");
            }
        }
    }
}

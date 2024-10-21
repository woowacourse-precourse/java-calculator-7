package calculator;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    static ArrayList<String> list = new ArrayList<>(Arrays.asList(",", ":"));

    public static void main(String[] args) {
        String[] delimiters;
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int answer;

        if (input.length() == 0) {
            answer = 0;
        } else {
            delimiters = splitDelimiter(input);
            answer = sumNumbers(delimiters);
        }

        System.out.println("결과 : " + answer);
    }

    static public String[] splitDelimiter(String input) {
        int start = 2, end;

        if (input.startsWith("//")) {
            end = input.indexOf("\\n");
            String delimiter = input.substring(start, end);
            list.add(delimiter);
            input = input.substring(end + 2);
        } else if (input.startsWith("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        } else if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c) && !list.contains(String.valueOf(c))) {
                throw new IllegalArgumentException("올바른 커스텀 구분자 형식을 사용하세요.");
            }
        }

        String det = "[";
        for (String s : list) {
            det += s;
        }
        det += "]";

        return input.split(det);
    }

    static int sumNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    int parsedNumber = Integer.parseInt(number.trim());
                    if (parsedNumber < 0) {
                        throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                    }
                    return parsedNumber;
                })
                .sum();
    }
}
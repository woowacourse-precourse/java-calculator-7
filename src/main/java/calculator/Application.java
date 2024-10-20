package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();

            String[] result = extractCustomDelimiter(input);
            String delimiter = result[0];
            String numberString = result[1];

            List<Integer> numbers = parseNumbers(numberString, delimiter);
            int sum = add(numbers);

            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static String[] extractCustomDelimiter(String input) {
        String delimiter = ",|:";
        String numberString = input;

        if (input.startsWith("//")) {
            int newLineIndex = -1;
            for (int i = 2; i < input.length() - 1; i++) {
                if (input.startsWith("\\n", i)) {
                    newLineIndex = i;
                    break;
                }
            }
            if (newLineIndex != -1) {
                delimiter = input.substring(2, newLineIndex);
                numberString = input.substring(newLineIndex + 2);
            }
        }

        return new String[]{delimiter, numberString};
    }

    public static List<Integer> parseNumbers(String input, String delimiter) {
        List<Integer> numbers = new ArrayList<>();

        System.out.println(input);
        System.out.println(delimiter);

        // input이 0일때 예외 처리
        if (input.isEmpty()) {
            numbers.add(0);
            return numbers;
        }

        String[] splitNumbers = input.split(delimiter);

        for (String number : splitNumbers) {
            try {
                int parsedNumber = Integer.parseInt(number.trim());
                numbers.add(parsedNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("INVALID INPUT");
            }
        }

        return numbers;
    }

    public static int add(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}

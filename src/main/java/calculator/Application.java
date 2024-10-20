package calculator;

import java.util.Scanner;

public class Application {
    public static int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        String numberString = numbers;

        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\\n");
            if (delimiterIndex != -1) {
                delimiter = escapeSpecialRegexChars(numbers.substring(2, delimiterIndex));
                numberString = numbers.substring(delimiterIndex + 2); // +2 to skip "\\n"
            } else {
                throw new IllegalArgumentException("Invalid input format: missing newline after custom delimiter.");
            }
        }

        String[] nums = numberString.split(delimiter);
        int sum = 0;

        for (String num : nums) {
            try {
                sum += Integer.parseInt(num.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input: non-numeric value found -> " + num);
            }
        }

        return sum;
    }

    public static String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\\\.*+?^${}()|\\[\\]])", "\\\\$1");
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.);
        String input = sc.nextLine();

        try{
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}

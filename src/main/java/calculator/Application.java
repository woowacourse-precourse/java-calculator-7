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
                System.out.println("error0");
                return 0;
            }
        }

        String[] nums = numberString.split(delimiter);
        int sum = 0;

        for (String num : nums) {
            try {
                sum += Integer.parseInt(num.trim());
            } catch (NumberFormatException e) {
                System.out.println("error" + num);
                return 0;
            }
        }

        return sum;
    }

    public static String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\\\.*+?^${}()|\\[\\]])", "\\\\$1");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int result = add(input);
        System.out.println(result);
    }
}

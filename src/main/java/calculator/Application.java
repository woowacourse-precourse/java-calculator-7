package calculator;

import java.util.Scanner;

public class Application {
<<<<<<< HEAD
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
=======
    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = input.split(",|;");
        int sum = 0;

        try {
            for (String number : numbers) {
                sum += Integer.parseInt(number.trim());
            }
        } catch (NumberFormatException e) {
            System.out.println("not number");
            return 0;
>>>>>>> 60fa33c7c09fd1493dc1394136ca44f72efd3545
        }

        return sum;
    }

<<<<<<< HEAD
    public static String escapeSpecialRegexChars(String delimiter) {
        return delimiter.replaceAll("([\\\\.*+?^${}()|\\[\\]])", "\\\\$1");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try{
            int result = add(input);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

=======
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int result = add(input);
        System.out.println("Sum: " + result);
>>>>>>> 60fa33c7c09fd1493dc1394136ca44f72efd3545
    }
}

package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitedNumber;
        int sum = 0;
        // //;\n1;2;3
        try {
            if (input.startsWith("//") && input.startsWith("\\n", 3)) {
                char sperator = input.charAt(2);
                String sparatorString = String.valueOf(sperator);
                splitedNumber = input.substring(5).split(sparatorString);

                System.out.println(splitedNumber);

                for (String number : splitedNumber) {
                    number.trim();
                    int num = Integer.valueOf(number);
                    sum += num;
                }
            } else {
                splitedNumber = input.split("[:,]");
                for (String number : splitedNumber) {
                    int num = Integer.parseInt(number);
                    sum += num;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }

        System.out.println(sum);

    }


}

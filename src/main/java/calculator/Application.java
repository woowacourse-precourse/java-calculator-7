package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitedNumber;
        int sum = 0;
        //  //;\n1;2;3
        try {
            if (input.startsWith("//") && input.startsWith("\\n", 3)) {
                char sperator = input.charAt(2);
                String sparatorString = String.valueOf(sperator);
                splitedNumber = input.substring(5).split(sparatorString);

            } else {
                splitedNumber = input.split("[:,]");

            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getSum(splitedNumber));

    }
    static int getSum(String[] array){
        int sum=0;
        for (String number : array) {
            int num = Integer.valueOf(number);
            sum += num;
        }
        return sum;
    }

}

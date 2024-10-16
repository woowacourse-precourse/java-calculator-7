package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.println("결과 : " + calculator(Console.readLine()));
    }

    private static int calculator(String input) throws IllegalArgumentException{

        String[] numbers = input.split("[,;]");

        int sum = 0;
        for (String number : numbers) {

            try {
                if (Integer.parseInt(number) < 0) {
                    throw new IllegalArgumentException();
                }
                sum += Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return sum;
    }

}

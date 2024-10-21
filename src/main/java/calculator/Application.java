package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String num[] = input.split("[,:]");
        int sum = 0;
        for (String number : num) {
            sum += Integer.parseInt(number);
        }
        System.out.println("결과 : "+sum);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String split = ",|:";
        if(input.startsWith("//")) {
            int end = input.indexOf("\n");
            split+=("|"+input.substring(2,end));
            input = input.substring(end+1);
        }
        String num[] = input.split(split);
        int sum = 0;
        for (String number : num) {
            sum += Integer.parseInt(number);
        }
        System.out.println("결과 : "+sum);
    }
}

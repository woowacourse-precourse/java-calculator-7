package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    // 기능1. 쉼표 또는 콜론으로 분리한 각 숫자의 합을 반환
    public static int basic_add(String string_to_calc){
        int answer = 0;

        String[] numbers = string_to_calc.split("[: ,]");
        for (String number : numbers){
            answer += Integer.parseInt(number);
        }

        return answer;
    }

    public static void main(String[] args) {
        String string_to_calc = Console.readLine();
        System.out.println(basic_add(string_to_calc));
    }
}

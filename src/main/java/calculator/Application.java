package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해주세요." + "\n");
        String Input = Console.readLine();

        int sum = 0;

        String[] tokens = Input.split("[,:]");

        for (String token : tokens) {
            token = token.trim();
            sum += Integer.parseInt(token);
        }

        System.out.println("결과 : " + sum);
    }
}


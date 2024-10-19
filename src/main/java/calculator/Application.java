package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiter = ",|:";
        String[] split = input.split(delimiter);
        int sum = 0;
        for (String token : split) {
            if(!token.isEmpty()){
                try {
                    int num = Integer.parseInt(token);
                    if (num < 0) {
                        throw new IllegalArgumentException("음수");
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("숫자가 아닌 문자");
                }
            }
        }




        System.out.println("결과 : " + sum);
    }
}

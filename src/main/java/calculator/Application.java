package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            String delimiter = "[,;]";
            String[] inputSplits = input.split(delimiter);
            int result = 0;

            for (String s : inputSplits) {
                if(s.isEmpty()) {
                    continue;
                }

                int number = Integer.parseInt(s);

                if(number <= 0) {
                    throw new IllegalArgumentException("마이너스 입력");
                }
                result += number;
            }

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력을 하였습니다.");
            System.out.println(e.getMessage());
        }
    }
}

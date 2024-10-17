package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try{
            System.out.println("덧셈할 문자열을 입력해주세요.");
            String input = Console.readLine();
            String[] splitInputs = input.split("[,;]");
            Integer result = 0;

            for (String s : splitInputs) {
                if(s.equals("")) {
                    result += 0;
                } else {
                    result += Integer.parseInt(s);
                }
            }

            System.out.println("결과 : " + result);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력을 하셨습니다.");
            System.out.println(e.getMessage());
        }
    }
}

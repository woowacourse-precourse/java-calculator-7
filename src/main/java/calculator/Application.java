package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            InputValidator.validate(input);
            if(input.startsWith("//")) {
                String[] parts = DelimiterParser.customDelimiterParse(input);
                System.out.println("커스텀 구분자: " + parts[0] + " ,숫자: " + parts[1]);
            }
//            System.out.println("결과 : " + 0);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("알 수 없는 오류가 발생했습니다. " + e.getMessage());
        }
    }
}

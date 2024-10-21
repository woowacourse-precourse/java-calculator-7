package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");
        }

        String delimiter = "[,:]";  // 쉼표 또는 콜론

        String[] strArr = str.split(delimiter);
        int sum = 0;
        
        for (String token : strArr) {
            try {
                int number = Integer.parseInt(token);
                sum += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }

        System.out.println("결과 : " + sum);
    }
}

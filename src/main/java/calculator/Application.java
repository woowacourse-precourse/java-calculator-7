package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 안내 메시지 출력
        System.out.println("덧셈할 숫자를 구분자와 함께 입력해주세요\n"
                + "기본 구분자는 : 와 , 이며 커스텀 구분자를 설정하고 싶으시다면 문장 맨 앞에 // 문자와 \\n 문자 사이에 1개의 문자를 설정해주시면 됩니다.");

        // 2. 문자열 입력 받기
        String input = Console.readLine();

        // 입력 값을 처리하여 결과를 계산하고 출력
        int result = StringCalculator.add(input);
        System.out.println("결과 : " + result);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String separators = ",|:";
        String input = Console.readLine();

        if (input.charAt(0) == '/') {
            separators += "|" + input.charAt(2); // 커스텀 구분자 추가
            input = input.substring(5); // 앞의 "//_\n" 버리기
        }

        String[] sArr = input.split(separators);

        long answer = 0;
        for (String s : sArr) {
            answer += Integer.parseInt(s);
        }

        System.out.println("결과 : " + answer);
    }
}

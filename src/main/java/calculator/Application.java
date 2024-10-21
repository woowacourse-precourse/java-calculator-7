package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String separators = ",|:";
        String input;

        try {
            input = Console.readLine();
            System.out.println(input.charAt(4));

            // 예외 처리 - 빈 문자열 입력 시
            if (input == null || input.isEmpty()) {
                throw new IllegalArgumentException("입력값이 비어 있습니다.");
            }

            // 커스텀 구분자 체크
            if (input.startsWith("//")) {
                if (input.length() < 4 || input.charAt(3) != '\n') {
                    throw new IllegalArgumentException("커스텀 구분자의 형식이 잘못되었습니다.");
                }
                separators += "|" + input.charAt(2); // 커스텀 구분자 추가
                input = input.substring(4); // 앞의 "//_\n" 제거
            }

            String[] sArr = input.split(separators);
            long answer = 0;
            for (String s : sArr) {
                answer += Integer.parseInt(s);
            }

            System.out.println("결과 : " + answer);

        } catch (IllegalArgumentException e) {
            return; // 프로그램 종료
        }
    }
}

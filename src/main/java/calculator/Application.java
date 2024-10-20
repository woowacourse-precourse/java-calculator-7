package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInputText = readLine();
        try {
            if (userInputText == null || userInputText.trim().isEmpty()) {
                throw new IllegalArgumentException("입력한 값이 없습니다.다시 확인 후 다시 입력해주세요");
            }
            System.out.println("결과 : " + userInputText);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
        }
    }
}

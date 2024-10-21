package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String delimiter = ",|:"; // 기본 구분자

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            System.out.println("결과 : " + 0);
            return;
        }

        if (input.startsWith("//")) { // 커스텀 구분자로 시작하는지 확인
            if (input.substring(3, 5).equals("\\n") && input.length() > 5) { // "\n"으로 끝나는지 확인
                delimiter = input.substring(2, 3);
                input = input.substring(5);
            }
            else if (input.substring(3, 5).equals("\\n") && input.length() == 5) { // 커스텀 구분자로 지정만 한 경우
                System.out.println("결과 : " + 0);
                return;
            }
            else if (input.length() < 5) {
                throw new IllegalArgumentException("문자열의 길이가 5보다 작습니다.");
            }
            else {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
        }
        else if (!isNumeric(input.substring(0, 1))) {
            throw new IllegalArgumentException("음수 혹은 잘못된 커스텀 구분자 입력입니다.");
        }


    }

    // 문자열이 양수인지 확인하는 함수
    public static boolean isNumeric(String str) {
        String regex = "[1-9]\\d*";
        return str.matches(regex);
    }

}

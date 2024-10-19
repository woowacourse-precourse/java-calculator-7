package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String numInput = Console.readLine();

        // 기본 구분자 ',' ':'로 문자열 분리
        String[] numbers = numInput.split("[,:]", -1); // -1은 빼고 될 듯. 일단 나중에 생각

        int sum = 0; // 덧셈 결과 저장할 변수

        for (String number : numbers) {
            number = number.trim(); // 숫자 앞 뒤 공백 제거

            if (number.isEmpty()) { // 빈 문자열 체크
                //sum += 0;
                continue;
            }
            try {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }
                sum += num; // 덧셈
            } catch (NumberFormatException e) {
                System.out.println("기본 구분자(',' ':')와 숫자를 제외한 문자를 입력하였습니다.");
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println("결과 : " + sum);
    }
}

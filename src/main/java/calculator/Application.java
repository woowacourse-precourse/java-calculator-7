package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 사용자 입력 받기
        System.out.println("구분자와 양수 구성된 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //빈 문자열 또는 null이 입력된 경우 0을 반환
        if(input == null || input.equals("")) {
            System.out.println("0");
            return;
        }


    }
}

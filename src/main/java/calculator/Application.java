package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);

        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
        String input = scanner.nextLine();

        //일단은 ,와: 기준으로만 문자열 분리
        // 커스텀 구분자 추가해야함!!!
        String[] parts = input.split("[,:]");

        int sum = 0;
        for(String part : parts) {
            try {
                //숫자라면 더하기
                sum += Integer.parseInt(part);
            } catch (NumberFormatException e) {
                //숫자가 아니라면 에러 처리
                throw new IllegalArgumentException("입력값 에러 발생 : " + part );

            }
        }
        System.out.println("결과 : " + sum);
    }
}

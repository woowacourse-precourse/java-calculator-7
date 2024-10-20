package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력 받기 위한 메시지 출력
        System.out.println("문자열을 입력해 주세요 : ");
        String input;

        // 우테코 Console API 사용
        // 콘솔에서 입력 받기
        input = Console.readLine();

        try {
            // 입력된 문자열로 계산하여 결과 출력
            int result = StringCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            // 입력 오류 시 오류 메시지 출력, 예외 던지기
            System.out.println("입력 오류 : " + e.getMessage());
            throw new IllegalArgumentException("입력 오류입니다.");
        } catch (Exception e) {
            System.out.println("예상하지 못한 오류가 발생했습니다: " + e.getMessage());
            throw new IllegalArgumentException("오류가 발생했습니다.");
        }
    }
}
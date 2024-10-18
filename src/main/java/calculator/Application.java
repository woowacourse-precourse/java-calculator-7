package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // 사용자에게 입력 요청
        System.out.print("문자열 입력: ");

        // 콘솔에서 입력받은 문자열을 input에 저장
        String input = Console.readLine();

        // 입력받은 문자열을 출력
        System.out.println("입력한 문자열: " + input);

        // 입력받은 문자열을 분리 후 숫자로 변환
        List<Integer> number = StringCalculator.splitAndConvert(input);

        // 숫자로 변환된 리스트의 총합 구하기
        int sum = StringCalculator.sumNumber(number);

        // 결과 출력
        System.out.println("결과 : " + sum);
    }
}

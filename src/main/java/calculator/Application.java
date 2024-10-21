package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // 구분자를 정의하는 ArrayList
        ArrayList<String> delimiter = new ArrayList<>();
        delimiter.add(",");
        delimiter.add(":");

        // 변수 선언
        int sum = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine(); // Console 클래스를 사용하여 입력 받기
        Console.close(); // 한번만 받을 것

        if (userInput.isEmpty()) {
            System.out.println("결과 : " + sum);
        } else {
            // 구분자를 정규식으로 변환하여 문자열을 구분
            String regex = String.join("|", delimiter); // 구분자를 '|'로 연결하여 정규 표현식 생성
            String[] numbers = userInput.split(regex); // 문자열을 구분자로 나누어 배열에 저장

            // 문자열 배열의 값을 숫자로 변환해 더하기
            for (String number : numbers) {
                sum += Integer.parseInt(number.trim()); // 공백 제거 후 정수로 변환해 더함
            }

            // 합계 출력
            System.out.println("결과 : " + sum);
        }
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // 기본 구분자 리스트 선언
        List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = Console.readLine(); // 사용자 입력 받기
        Console.close();

        if (userInput.isEmpty()) {
            System.out.println("결과 : " + 0);
        } else {
            String numberPart;
            // 입력이 //로 시작하는지 확인
            if (userInput.startsWith("//")) {
                String[] parts = userInput.split("\\\\n");
                String customDelimiter = parts[0].substring(2); // 커스텀 구분자 추출
                numberPart = parts[1]; // 계산식 부분 추출

                delimiters.add(Pattern.quote(customDelimiter)); // 커스텀 구분자 추가
            } else {
                numberPart = userInput; // 계산식 부분
            }

            // 2. 덧셈 및 결과 출력
            int result = calculateSum(numberPart, delimiters);
            System.out.println("결과 : " + result);
        }
    }

    // 합계 계산 메서드
    private static int calculateSum(String numberPart, List<String> delimiters) {
        // 변수 선언
        int sum = 0; // 합계를 저장할 변수

        String regex = String.join("|", delimiters); // 구분자 리스트를 정규식으로 변환
        String[] numbers = numberPart.split(regex); // 구분자를 기준으로 숫자 나누기

        for (String number : numbers) {
            String trimmedNumber = number.trim(); // 공백 제거

            // 숫자 형식 검증 (음수를 포함한 숫자)
            if (!trimmedNumber.matches("\\d+")) {
                throw new IllegalArgumentException("유효하지 않은 입력: " + trimmedNumber + "은 양수가 아닙니다.");
            }
            sum += Integer.parseInt(number);
        }

        return sum;
    }
}

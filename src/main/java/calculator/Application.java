package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static String inputString;
    private static String[] stringArray;
    private static int total;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine();

        // 기본 값 설정
        total = 0;

        try {
            // 빈 문자열 처리
            if (inputString.isEmpty()) {
                System.out.println(total);
                return;
            }

            // 커스텀 구분자 처리 - \\n 대신 실제 줄바꿈이 아닌 텍스트로 매칭
            Pattern pattern = Pattern.compile("//(.)\\\\n(.*)");
            Matcher matcher = pattern.matcher(inputString);
            String delimiter = ",|:"; // 기본 구분자

            if (matcher.matches()) {
                delimiter = Pattern.quote(matcher.group(1)); // 커스텀 구분자 설정
                inputString = matcher.group(2); // 실제 숫자 부분
            }

            // 구분자를 기준으로 문자열 분리
            stringArray = inputString.split(delimiter);

            // 각 숫자의 합 계산
            for (String s : stringArray) {
                try {
                    int number = Integer.parseInt(s.trim()); // 문자열을 정수로 변환

                    // 음수 입력에 대한 예외 처리
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다. 입력된 음수: " + number);
                    }

                    total += number; // 합산
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 구분자가 있습니다. 발견된 문자열: " + s); // 숫자 형식 오류 시 예외 발생
                }
            }

            // 결과 출력
            System.out.println(total);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1); // 명시적으로 종료
        }
    }
}

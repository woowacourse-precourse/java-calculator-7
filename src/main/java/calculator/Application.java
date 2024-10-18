package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        // scanner 변수 선언
        Scanner scanner = new Scanner(System.in);

        // 숫자의 합을 저장할 변수 선언
        int answer = 0;

        try {

            String input = scanner.nextLine();
            String[] delimiters = {",", ":"}; // 기본 구문자 설정

            // //로 문장이 시작하는 지 체크
            if (input.startsWith("//")) {

                // \n의 위치 찾기
                int endpointIndex = input.indexOf("\\n");

                // \n을 못찾았거나 각 단어 사이의 문자가 있는 지 체크
                if (endpointIndex != -1 && endpointIndex > 2) {
                    // // 뒤에서 \n 이전까지의 문자열을 구분자로 사용
                    String customDelimiters = input.substring(2, endpointIndex);

                    delimiters = customDelimiters.split("");  // 개별 문자를 구분자로 사용

                    // 입력 문자열에서 실제 값만 남기기 (구분자 정의 부분 제외)
                    input = input.substring(endpointIndex + 2);
                }

            }

            //구분자를 |를 기준으로 합침
            String regex = String.join("|", delimiters);
            // 구분자를 기준으로 문자열을 자름
            String[] numbers = input.split(regex);
            // 분리된 문자열을 숫자로 변환하여 출력

            for (String numberStr : numbers) {
                try {
                    int number = Integer.parseInt(numberStr.trim());  // 숫자로 변환
                    answer += number;
                } catch (NumberFormatException e) {
                    // 숫자가 아닌 부분은 무시하거나 오류 처리
                    System.err.println("유효하지 않은 숫자: " + numberStr);
                    System.exit(1);
                }
            }

            // 정답 출력
            System.out.println("결과 : " + answer);

            scanner.close();
        } catch (IllegalArgumentException e) {
            System.err.println("오류 : " + e.getMessage());
            System.exit(1);
        } finally {
            scanner.close();
        }
    }
}
